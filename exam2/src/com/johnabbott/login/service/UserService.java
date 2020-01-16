package com.johnabbott.login.service;

import com.johnabbott.login.model.User;

public interface UserService {
	public boolean addUser(User usr);
	
	public boolean verifyUser(String userEmail, String userPassword);
}
