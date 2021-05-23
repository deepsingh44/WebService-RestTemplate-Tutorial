package com.deepsingh44.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public int register(User user) {
		return userDao.register(user);
	}

	@Transactional
	public User login(String email, String pass) {
		return userDao.login(email, pass);
	}
}
