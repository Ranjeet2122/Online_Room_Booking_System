
package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room extends BaseEntity {
//	@NotBlank(message = "Room no can't be blank")
//	@Length(min = 1, max = 4, message = "invalid No!!!!!")

	@Length(min = 10, max = 200, message = "lenght should be 10-200 character!")
	private String discription;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Room Type is req")
	private Room_Type room_Type;
	@NotNull(message = "Price is req")
	private double pricePerDay;
	private String feedback;

	public Room() {
		
	}


	public Room(@Length(min = 10, max = 200, message = "lenght should be 10-200 character!") String discription,
			@NotNull(message = "Room Type is req") Room_Type room_Type,
			@NotNull(message = "Price is req") double pricePerDay, String feedback) {
		super();
		this.discription = discription;
		this.room_Type = room_Type;
		this.pricePerDay = pricePerDay;
		this.feedback = feedback;
	}


	public Room(Room_Type room_Type2) {
		this.room_Type=room_Type2;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "hotelId", nullable = false)
	private Hotel hotelRoom;

	public Hotel getHotelRoom1() {
		return hotelRoom;
	}

	public void setHotelRoom1(Hotel hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

	/*
	 * public int getNo() { return no; }
	 * 
	 * public void setNo(int no) { this.no = no; }
	 */

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

	
	public Hotel getHotelRoom() {
		return hotelRoom;
	}


	public void setHotelRoom(Hotel hotelRoom) {
		this.hotelRoom = hotelRoom;
	}


	@Override
	public String toString() {
		return "Room [no="  + ", discription=" + discription + ", room_Type=" + room_Type + ", pricePerDay="
				+ pricePerDay + ", feedback=" + feedback + ", hotelRoom=" + hotelRoom + "]";
	}

}
