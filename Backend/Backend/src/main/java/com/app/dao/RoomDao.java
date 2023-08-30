package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Hotel;
import com.app.pojos.Room;

public interface RoomDao extends JpaRepository<Room, Long> {

	List<Room>findByhotelRoom(Hotel hotel);

//	void DeleteByHotelid(Long id);
}
