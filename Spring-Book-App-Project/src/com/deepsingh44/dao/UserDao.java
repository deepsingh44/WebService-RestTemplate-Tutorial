package com.deepsingh44.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.deepsingh44.model.User;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public int register(User user) {
		int i = 0;
		sessionFactory.getCurrentSession().save(user);
		return i = 1;
	}

	public User login(String email, String pass) {
		boolean status = false;
		User user = sessionFactory.getCurrentSession().get(User.class, email);
		if (user != null) {
			status = (user.getPass().equals(pass)) ? true : false;
		}
		return (status) ? user : null;
	}
}
