package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking extends BaseEntity implements Serializable {

	private int NoofBooked;

	private String checkInDate;
	private String checkOutDate;
	private int numGuests;
	private String roomType;
//	private int totalPrice;

	@ManyToOne
	
	@JoinColumn(name = "UserEmail", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "hotelId", nullable = false)
	private Hotel hotel;

	public int getNoofBooked() {
		return NoofBooked;
	}

	public Booking() {

	}
	public Booking(int noofBooked, String checkInDate, String checkOutDate, int numGuests, String roomType) {
		super();
		NoofBooked = noofBooked;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numGuests = numGuests;
		this.roomType = roomType;
		
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void setNoofBooked(int noofBooked) {
		NoofBooked = noofBooked;
	}
	
	
}
