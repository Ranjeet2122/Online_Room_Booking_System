package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.app.pojos.Room_Type;

public class createRoom {
	private Long hotelId;
	private String discription;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Room Type is req")
	private Room_Type room_Type;
	@NotNull(message = "Price is req")
	private double pricePerDay;
	private String feedback;
	
	public createRoom() {
		// TODO Auto-generated constructor stub
	}



	public createRoom(Long hotelId, String discription, @NotNull(message = "Room Type is req") Room_Type room_Type,
			@NotNull(message = "Price is req") double pricePerDay, String feedback) {
		super();
		this.hotelId = hotelId;
		this.discription = discription;
		this.room_Type = room_Type;
		this.pricePerDay = pricePerDay;
		this.feedback = feedback;
	}



	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Room_Type getRoom_Type() {
		return room_Type;
	}

	public void setRoom_Type(Room_Type room_Type) {
		this.room_Type = room_Type;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	
}
