package com.example.demo.dtos;

import com.example.demo.entity.Role;

public class UserDTO {
	
	 private Long userId;
	 private String userName;
	 private String email;
	 private Role role;
	 
	 public UserDTO() {}

	public UserDTO(Long userId, String userName, String email, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	 
	

}
