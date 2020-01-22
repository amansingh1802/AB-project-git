package com.project.service;

import com.project.pojos.User;

public interface IUserService 
{
	User validateUser(User u);
	Boolean registerUser(User u);
	User getPassword(String username);
	Boolean changePassword(User u);
}
