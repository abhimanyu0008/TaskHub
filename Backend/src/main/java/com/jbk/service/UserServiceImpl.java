package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public Object loginUser(User user) {
		var result=dao.loginUser(user);
		return result;
	}
	@Override
	public User registerUser(User user) {	
		return dao.registerUser(user);
	}
	@Override
	public boolean changePassword(String username, String newPassword) {
		return dao.changePassword(username, newPassword);
	}
	}

