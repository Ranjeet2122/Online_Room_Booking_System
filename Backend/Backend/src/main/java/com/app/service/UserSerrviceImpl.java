package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;

import com.app.dao.MemberDao;
import com.app.pojos.Hotel;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional
public class UserSerrviceImpl implements UserService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public User userLogin(String email, String password) {
		return memberDao.findByEmailAndPassword(email, password);
	}

	@Override
	public User userSignUp(User user) {

		return memberDao.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		if (memberDao.existsById(id)) {
			return memberDao.save(user);
		}

		throw new ResourceNotFoundException("Invalid Id!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	@Override
	public String updateUserPasswordByEmail(String password, String email) {
		memberDao.updateUserPasswordByEmail(password, email);
		return "User password updated successfully";
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return memberDao.findAll();
	}

	@Override
	public User findbyrole(Role role) {
		// TODO Auto-generated method stub
		return memberDao.findByRole(role);
	}

	@Override
	public User resetPassword(User user, String password) {
		// TODO Auto-generated method stub
		String pass = (password);
		System.out.println(pass + " :: ");
		user.setPassword(pass);
		User persistentUser = memberDao.save(user);
		return persistentUser;
	}

//	@Override
//	public AppUser resetPassword(AppUser user, String password) {
//		
//		String pass = (password);
//		System.out.println(pass +" :: ");
//		user.setPassword(pass);
//		AppUser persistentUser = memberDao.save(user);
//		return persistentUser;
//	}

	@Override
	public User checkEmail(String email) {
		// TODO Auto-generated method stub
		User user = memberDao.findByEmail(email);
		return user;
	}

}
