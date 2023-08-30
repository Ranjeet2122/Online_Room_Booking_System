package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.HotelRepository;
import com.app.dao.RoomDao;
import com.app.dto.createRoom;
import com.app.pojos.Hotel;
import com.app.pojos.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private HotelRepository hotelRepo;
	@Autowired
	private RoomDao roomDao;

	@Override
	public Room createRoom(createRoom request) {
		Hotel hotel =  hotelRepo.getById(request.getHotelId());
		Room room = new Room(request.getDiscription(),request.getRoom_Type(),request.getPricePerDay(),request.getFeedback());
		room.setHotelRoom(hotel);
		return roomDao.save(room);
	}
//
//	@Override
//	public Room addRoom(Room room) {
//		// TODO Auto-generated method stub
//		return roomDao.save(room);
//	}

	

//	public String deleteRoom(Long id1) {
//		
//		roomDao.deleteById(id1);// TODO Auto-generated method stub
//		return ;
//	}

//	public String deleteRoom(Long id1)
//	{
////		Room room=new Room(roomtype.getRoom_Type());
//		
//		return ;
//	}
}
