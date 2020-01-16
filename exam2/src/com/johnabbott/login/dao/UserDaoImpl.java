package com.johnabbott.login.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.login.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertUser(User usr) {
		sessionFactory.getCurrentSession().save(usr);
		return 1;
	}

	
	/*This method should fetch a user in the database that has both the entered email and password. Should it fail to populate the list then it returns a value of 0.*/
	@Override
	public int getUser(String userEmail, String userPassword) {
		List<User> list = sessionFactory.getCurrentSession().
				createQuery("from User where "
				+ "email='"+userEmail+ "'" + " AND " + "password='"+userPassword+ "'", User.class).list();
		
		if (list.size() > 0)
			return 1;
		else
			return 0;
	}

}
