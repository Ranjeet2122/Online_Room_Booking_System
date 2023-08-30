package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Booking;
import com.app.pojos.Hotel;

public interface BookingDao extends JpaRepository<Booking, Long>{
//	 List<Booking> findByhotelRoom(Hotel hotel);
//	 Optional<Booking> findById(Long id);
//	    List<Booking> findAll();
//	    void save(Booking booking);
//	    void update(Booking booking);
//	    void delete(Long id);
}
