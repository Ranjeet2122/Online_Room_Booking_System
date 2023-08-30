package com.app.service;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.Hotel;
import com.app.pojos.Room;
import com.app.pojos.User;

public interface HotelService {

	public List<Hotel> findHotelsByName(String name);

	public Hotel addHotel(Hotel hotel);

	public List<Hotel> findAll();

	public Booking find(Long id);

}