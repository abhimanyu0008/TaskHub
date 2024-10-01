package com.jbk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class AuthController {

	@Autowired
	private UserService service;

	@CrossOrigin(methods = RequestMethod.POST)
	@PostMapping("/register-user")
	public ResponseEntity<String> registerUser(@RequestBody  User user) {
		User registerUser = service.registerUser(user);
		if (registerUser != null) {
			return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/login-user")
	public ResponseEntity<Object> loginUser(@RequestBody User user) {
		var result = service.loginUser(user);
		if (result instanceof String) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PutMapping("/change-password")
	public ResponseEntity<Map<String, String>> changePassword(@RequestBody Map<String, String> passwordData) {
	    String username = passwordData.get("username");
	    String newPassword = passwordData.get("newPassword");

	    boolean isPasswordChanged = service.changePassword(username, newPassword);
	    Map<String, String> response = new HashMap<>();

	    if (isPasswordChanged) {
	        response.put("message", "Password updated successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        response.put("message", "User not found");
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	}
}
