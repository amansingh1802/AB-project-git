package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.IUserDao;
import com.project.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserDao userdao;

	@Override
	public User validateUser(User u) {
		return userdao.validateUser(u);
	}

	@Override
	public Boolean registerUser(User u) {
		return userdao.registerUser(u);
	}

	@Override
	public User getPassword(String username) {
		return userdao.getPassword(username);
	}

	@Override
	public Boolean changePassword(User u) {
		return userdao.changePassword(u);
	}
}
