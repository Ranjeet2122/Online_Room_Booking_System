package com.app.service;

import java.util.List;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserService {
	User userLogin(String email, String password);

	User userSignUp(User user);

	User updateUser(Long id, User user);

	String updateUserPasswordByEmail(String password, String email);

	User findbyrole(Role role);

	public List<User> findAll();

	User resetPassword(User user, String password);

	User checkEmail(String email);
//	User updatePass(String pass);

}