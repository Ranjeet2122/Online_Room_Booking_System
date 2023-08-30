package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.comman.Email;
import com.app.dao.MemberDao;
import com.app.pojos.User;
import com.app.security.CryptWithMD5;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MemberDao dao;

	public UserController() {
		System.out.println("in ctr of" + getClass());
	}

	@PostMapping("/login") // => read only access
	public ResponseEntity<?> userLogin1(@RequestBody User use) {
		System.out.println("in login user details");
		System.out.println(use.getEmail());
		String encrypted_Password = CryptWithMD5.cryptWithMD5(use.getPassword());
		System.out.println(encrypted_Password);
		User user = dao.findByEmailAndPassword(use.getEmail(), encrypted_Password);
		// AppUser user = dao.findByEmailAndPassword(use.getEmail(), use.getPassword());
//		System.out.println(use.getEmail());
//		System.out.println(encrypted_Password);
		System.out.println(user.getPassword());
		

		if (1 == 1) {
			System.out.println("Imside in there Role");
			System.out.println(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>((user), HttpStatus.OK);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		user.setPassword(CryptWithMD5.cryptWithMD5(user.getPassword()));
		System.out.println("in Signup user details");
		// ResponseEntity(T body, HttpStatus status)
		return new ResponseEntity<>(userService.userSignUp(user), HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		System.out.println("Inside into all users");
		return userService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
		System.out.println("in login user details");
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@PostMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(@RequestBody User cred) {
		System.out.println(cred.getEmail() + "  " + cred.getPassword());
		User checkUserEmail = userService.checkEmail(cred.getEmail());
		System.out.println(checkUserEmail);
		Email.sendEmail(cred.getEmail());
		System.out.println(cred.getEmail());
		User persistentUser = userService.resetPassword(checkUserEmail, cred.getPassword());
		System.out.println(persistentUser);
		if (persistentUser != null) {
			System.out.println("password reset sucessfully");
			return new ResponseEntity<>("Set password successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Set password failed", HttpStatus.BAD_REQUEST);
		}

	}

}
