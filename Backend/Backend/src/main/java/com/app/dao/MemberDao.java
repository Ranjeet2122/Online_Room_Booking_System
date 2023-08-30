package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface MemberDao extends JpaRepository<User, Long>{
	
	User findByEmailAndPassword(String email, String password);
//	 User findByEmail(String email);
	@Modifying
	@Query("update User u set u.password=:password where u.email =:email")
	void updateUserPasswordByEmail(@Param ("password") String password ,@Param ("email") String email );
	
	User findByEmail(String email);
	User findByRole(Role role);
}
