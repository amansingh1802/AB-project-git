package com.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public User validateUser(User u) 
	{
		String jpql = "select u from User u where u.email = :em and u.password = :pswd";
		return sf.getCurrentSession().createQuery(jpql, User.class)
				.setParameter("em", u.getEmail())
				.setParameter("pswd", u.getPassword())
				.getSingleResult();
	}

	@Override
	public Boolean registerUser(User u) {
		System.out.println("UserDaoImpl.registerUser :"+u);
		try {
			sf.getCurrentSession().persist(u);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public User getPassword(String username) {
		String jpql = "select u from User u where u.email=:username";
		try {
			return sf.getCurrentSession().createQuery(jpql, User.class)
					.setParameter("username", username).getSingleResult();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean changePassword(User u) {
		try {
			String jpql = "select u from User u where u.email=:email";
			User uOld = sf.getCurrentSession().createQuery(jpql, User.class)
					.setParameter("email", u.getEmail()).getSingleResult();
			uOld.setPassword(u.getPassword());
			
			sf.getCurrentSession().update(uOld);
				return true;
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
}
