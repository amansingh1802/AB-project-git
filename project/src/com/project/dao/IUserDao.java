package com.project.dao;

import com.project.pojos.User;

public interface IUserDao 
{
	User validateUser(User u);
	Boolean registerUser(User u);
	User getPassword(String username);
	Boolean changePassword(User u);
}
