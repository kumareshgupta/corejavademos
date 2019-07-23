package com.urs.service;

import com.urs.dao.UserDao;
import com.urs.model.User;

public class UserService {
	UserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	public String getUserDetails(int userId){
		String name = userDao.getUserDetails(userId);
		return name;
		
	}
}
