package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.ManagerDao;
import com.app.pojos.User;

public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao mgrDao;

	@Override
	public User managerSignIn(String email, String password) {
		// TODO Auto-generated method stub
		return mgrDao.findByEmailAndPassword(email, password);
	}

}
