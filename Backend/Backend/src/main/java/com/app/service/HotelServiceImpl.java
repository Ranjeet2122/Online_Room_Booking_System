package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookingDao;
import com.app.dao.HotelRepository;
import com.app.dao.RoomDao;
import com.app.pojos.Booking;
import com.app.pojos.Hotel;
import com.app.pojos.Room;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomDao roomdoa;
	@Autowired
	private BookingDao bookingdao;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> findHotelsByName(String name) {
		return hotelRepository.findByName(name);
	}

	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	public Hotel findByid(Long id) {
		// TODO Auto-generated method stub
		return hotelRepository.getById(id);
	}

	@Override
	public Booking find(Long id) {
		// TODO Auto-generated method stub
		return bookingdao.getById(id);
	}

//	@Override
//	public List<Booking> find(Long id) {
//		// TODO Auto-generated method stub
//		return bookingdao.findById(id);
//	}

//	@Override
//	public Room addRoom(Room room) {
//		// TODO Auto-generated method stub
//		return roomdoa.save(room);
//	}

//	@Override
//	public List<Room> findByAllHotelRoom(String name) {
//		return hotelRepository.findByname(name);
//	}
}
