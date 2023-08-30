package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ManagerDao;
import com.app.pojos.User;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerDao mgrDao;
	
	@Autowired
	private UserService userService;

	public ManagerController() {
		System.out.println("in ctr of" + getClass());
	}

	@PostMapping("/login") // => read only access
	public ResponseEntity<?> mgrLogin(@RequestBody User mgr) {
		System.out.println("in login manager details");
		// ResponseEntity(T body, HttpStatus status)

		User mgr1 = mgrDao.findByEmailAndPassword(mgr.getEmail(), mgr.getPassword());
		// System.out.println(mgr.getEmail());
		return new ResponseEntity<>((mgr1.getName()), HttpStatus.OK);
		// return new ResponseEntity<>(mgrDao.findByEmailAndPassword(mgr.getEmail(),
		// mgr.getPassword()), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		System.out.println("in login user details");
		// ResponseEntity(T body, HttpStatus status)
		return new ResponseEntity<>(userService.userSignUp(user), HttpStatus.OK);
	}
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
//		System.out.println("in login user details");
//		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
//	}
//	
//	@PatchMapping("/{email}")
//	public String uupdateUserPasswordByEmail(@RequestBody Map<String,String> mp,@PathVariable String email) {	
//		return userService.updateUserPasswordByEmail(mp.get("password"),email);
//	}

//	@PatchMapping("/{email}")
//	public String updateUserPassword(@RequestBody User us) {
//		System.out.println("inside passsword changes ");
//		return 
//		}
}
//	@GetMapping("/desc/{keyword}")
//	public ResponseEntity<?> getUsersByDesc(@PathVariable String keyword) {
//		System.out.println("in get users by desc " + keyword);
//		return ResponseEntity.status(HttpStatus.OK).
//				body(userService.findByNameContaining(keyword));
//	}
