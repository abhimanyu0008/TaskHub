package com.jbk.dao;

import com.jbk.entity.User;

public interface UserDao {

	Object loginUser(User user);

	User registerUser(User user);

	boolean changePassword(String username, String newPassword);

}
