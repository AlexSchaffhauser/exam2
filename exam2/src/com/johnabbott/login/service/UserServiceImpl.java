package com.johnabbott.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.login.dao.UserDao;
import com.johnabbott.login.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean addUser(User usr) {
		return userDao.insertUser(usr) > 0 ;
	}

	@Override
	public boolean verifyUser(String userEmail, String userPassword) {
		return userDao.getUser(userEmail, userPassword) > 0 ;
	}

}
