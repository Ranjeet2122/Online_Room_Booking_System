package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Booking;
import com.app.pojos.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	List<Hotel> findByName(String name);

	Optional<Hotel> findById(Long id);

	@Modifying
	@Query("update User u set u.password=:password where u.email =:email")
	void updateUserPasswordByEmail(@Param("password") String password, @Param("email") String email);

}
