package com.jbk.service;

import com.jbk.entity.User;

public interface UserService {

	Object loginUser(User user);

	User registerUser(User user);

	boolean changePassword(String username, String newPassword);


}
