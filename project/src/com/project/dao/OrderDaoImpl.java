package com.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojos.Order;

@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public Order getOrderById(int orderId) {
		try {
			return sf.getCurrentSession().get(Order.class, orderId);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Boolean saveOrUpdateOrder(Order o) {
		try {
			sf.getCurrentSession().saveOrUpdate(o);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean deleteOrder(Order o)
	{
		try {
			sf.getCurrentSession().delete(o);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
