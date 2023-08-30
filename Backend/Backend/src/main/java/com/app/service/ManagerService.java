package com.app.service;

import com.app.pojos.User;

public interface ManagerService {

	User managerSignIn(String email, String password);
}
