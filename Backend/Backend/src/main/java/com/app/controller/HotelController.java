package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.dao.HotelRepository;
import com.app.dao.RoomDao;
import com.app.dto.createRoom;
import com.app.pojos.Booking;
import com.app.pojos.Hotel;
import com.app.pojos.Room;
import com.app.service.HotelServiceImpl;
import com.app.service.RoomService;
@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelServiceImpl hotelService;

	@Autowired
	private HotelRepository hotelRepo;

	@Autowired
	private RoomService roomservice;

	@Autowired
	private RoomDao roomRepo;

	@PostMapping("/hotels") // Hotel add
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel) {
		System.out.println("Inside into hotel");
		// return new ResponseEntity<>(, HttpStatus.OK);
		return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.OK);
	}

	@GetMapping("/hotels") // Show all hotel
	public List<Hotel> getAllHotels() {
		System.out.println("Inside into hotel");
		return hotelService.findAll();
	}

	@GetMapping("/hotels/") // find hotel by name
	public List<Hotel> findHotelsByName(@RequestParam String name) {
		return hotelService.findHotelsByName(name);
	}

	@GetMapping("getRoomByHotel/{id}") // Show room by hotel id
	public ResponseEntity<?> getRoomByHotel(@PathVariable Long id) {
		System.out.println("Inside in there Hotel Id");
		Hotel hotel = hotelRepo.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(roomRepo.findByhotelRoom(hotel));
	}

	@PostMapping("/addRoom") // Add room Type
	public String addRoom(@RequestBody createRoom request) {
		System.out.println("in add Room");
		Room room = roomservice.createRoom(request);
		return "Room Added";
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<?> bookingRoom(@PathVariable Long id) {
		System.out.println("Inside Booking Table");
		Booking booking = hotelService.find(id);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

}