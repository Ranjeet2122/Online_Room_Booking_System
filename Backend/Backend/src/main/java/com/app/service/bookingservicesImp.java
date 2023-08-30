package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookingDao;
import com.app.dao.HotelRepository;
import com.app.dao.MemberDao;
import com.app.dto.CreateBooking;
import com.app.pojos.Booking;
import com.app.pojos.Hotel;
import com.app.pojos.User;

@Service
@Transactional

public class bookingservicesImp implements BookingServices {

	@Autowired
	private HotelRepository hotelRepo;
	@Autowired
	private MemberDao memDao;
	@Autowired
	private BookingDao bookingDao;

	
	@Override
	public Booking CreateBooking(CreateBooking request) {

//		Hotel hotel =  hotelRepo.findAll(request.getHotelId()).get();
		User user = memDao.findByEmail(request.getUserId());
		Hotel hotel = hotelRepo.findById(request.getBookingHotel()).get();

		Booking book = new Booking(request.getNoofBooked(), request.getCheckInDate(), request.getCheckOutDate(),
				request.getNumGuests(), request.getRoomType());
		book.setUser(user);
		book.setHotel(hotel);

//		Booking booking=new Booking(request.getNoofBooked(),request.getCheckInDate(),request.getCheckOutDate(),request.getNumGuests(),request.getRoomType());

		return bookingDao.save(book);
	}




//    @Override
//    public Booking createBooking(CreateBooking request) {
//        // map DTO fields to POJO fields
//        Booking booking = new Booking();
//        booking.setCheckInDate(request.getCheckInDate());
//        booking.setCheckOutDate(request.getCheckOutDate());
//        booking.setNumGuests(request.getNumGuests());
//        booking.setRoomType(request.getRoomType());
//        
//        // save the booking to the database
//        bookingDao.save(booking);
//        
//        return booking;
//    }
//    

}
