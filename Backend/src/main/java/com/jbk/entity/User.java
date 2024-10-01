package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @Data @ToString
@Entity
@Table(name = "userInfo")
public class User {
	@Id
//	private long id;
	private String username;
	@NotBlank(message="Name is mendatory")
	private String fullName;
	@NotBlank(message="password is mendatory")
	private String password;
	@NotBlank(message="email is mendatory")
	private String email;
	@NotBlank(message="phone number is mendatory")
	private String phone;
	@NotBlank(message="gender is mendatory")
	private String gender;
	

}
