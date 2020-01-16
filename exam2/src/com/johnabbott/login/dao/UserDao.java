package com.johnabbott.login.dao;

import com.johnabbott.login.model.User;

public interface UserDao {
	public int insertUser(User usr);
	
	public int getUser(String userEmail, String userPassword);
}
