package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BookingDao;
import com.app.dao.HotelRepository;
import com.app.dto.CreateBooking;
import com.app.pojos.Booking;
import com.app.pojos.Hotel;
import com.app.service.BookingServices;
import com.app.service.HotelService;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
	

	@Autowired
	public BookingServices bookingser;

	@Autowired
	public BookingDao bookingDao;
	
	@Autowired
	public HotelRepository hotelRepo;
	

//	public ResponseEntity<?> addRoom(@RequestBody CreateBooking request) {
//		System.out.println("in add Room");
//		Room room=roomservice.createRoom(request);
//		return new ResponseEntity<>(room , HttpStatus.OK);
//	}
//
//    @DeleteMapping("/bookings/{id}")
//    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
//        bookingRepository.deleteById(id);
//        return new ResponseEntity<>("Booking deleted successfully", HttpStatus.NO_CONTENT);
//    }

	@PostMapping("/book")
	public String addBooking(@RequestBody CreateBooking booking) {

		System.out.println(booking.getBookingHotel());
		System.out.println(booking.getRoomType());
		System.out.println(booking.getUserId());
         
		Hotel hotel =hotelRepo.findById(booking.getBookingHotel()).get();
	int ab=	hotel.getAvailableDelux();
	int cd=	hotel.getAvailableNonDelux();
	int kd=	hotel.getBookedRoomDelux();
	int ls;
	String name=booking.getRoomType();
	System.out.println(name);
	int value=ab-(booking.getNoofBooked());
		if(name.equals("NON_DELUX")) {
		System.out.println("853254215465454654546");
		int booked=kd+(booking.getNoofBooked());
		hotel.setBookedRoomNonDelux(booked);
		int value1=cd-(booking.getNoofBooked());
		hotel.setAvailableNonDelux(value1);
		hotelRepo.save(hotel);
}
		else{
			int booked=kd+(booking.getNoofBooked());
			hotel.setBookedRoomDelux(booked);
			int value1=cd-(booking.getNoofBooked());
			hotel.setAvailableDelux(value1);
			hotelRepo.save(hotel);
//		hotel.setBookedRoom(booking.get);
		
	}
//	  } 
//		hotel.setBookedRoom());
//		
		
		bookingser.CreateBooking(booking);

		return "Booking Conform";
	}

	@PutMapping("/update/{id}")//userid
	public ResponseEntity<?> updateBooking(@RequestBody Booking book, @PathVariable Long id) {
		Booking book1 = bookingDao.findById(id).get();

		book1.setNoofBooked(book.getNoofBooked());
		book1.setCheckInDate(book.getCheckInDate());
		book1.setCheckOutDate(book.getCheckOutDate());
		book1.setNoofBooked(book.getNoofBooked());
		book1.setNumGuests(book.getNumGuests());
		book1.setRoomType(book.getRoomType());
		bookingDao.save(book1);
		
		return new ResponseEntity<>(bookingDao.save(book1), HttpStatus.OK);

	}
	
	@PostMapping("/cancalation/{id}")
	public String cancaltiondone(@PathVariable Long id)
	{
		Booking book1=bookingDao.findById(id).get();
		
		bookingDao.delete(book1);
		
		return "Canclation Done";
		
	}
	
	@GetMapping("/detail")
	public ResponseEntity<?> Detailbooking()
	{ 
//		User user=userdao.findByEmail();
		
		List<Booking> book1=bookingDao.findAll();
		return new ResponseEntity<>(book1, HttpStatus.OK);
		
	}
	
	@GetMapping("/bookingdetail/{id}")
	public Booking getBookingDetail(@PathVariable Long id) {
		return bookingDao.findById(id).get();
	}
	
	
	
}
