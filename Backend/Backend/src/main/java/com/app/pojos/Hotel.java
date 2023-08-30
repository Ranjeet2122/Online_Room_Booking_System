package com.app.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Hotel extends BaseEntity implements Serializable {
	@NotBlank(message = "name can't be blank")
	@Length(min = 4, max = 20, message = "invalid name!!!!!")
	@Column(name = "hotel_name", length = 20)
	private String name;
	@Length(min = 10, max = 200, message = "lenght should be 10-200 character!")
	private String discription;
	@NotNull
	private String location;
	@NotNull(message = "email is req")
	private String email;
	@NotNull(message = "Hotel Pan No is req")
	@Column(length = 10, unique = true)
	private String hPanNo;
	@NotNull(message = "Status is req")
	private Boolean is_Active;
	private int totalDeluxRoom;
	private int totalNonDeluxRoom;
	private int bookedRoomNonDelux;
	private int bookedRoomDelux;
	private int availableDelux;
	private int availableNonDelux;

	public Hotel() {
		super();
	}

	public Hotel(
			@NotBlank(message = "name can't be blank") @Length(min = 4, max = 20, message = "invalid name!!!!!") String name,
			@Length(min = 10, max = 200, message = "lenght should be 10-200 character!") String discription,
			@NotNull String location, @NotNull(message = "email is req") String email,
			@NotNull(message = "Hotel Pan No is req") String hPanNo,
			@NotNull(message = "Status is req") Boolean is_Active, int totalDeluxRoom, int totalNonDeluxRoom,
			int bookedRoomNonDelux, int bookedRoomDelux, int availableDelux, int availableNonDelux) {
		super();
		this.name = name;
		this.discription = discription;
		this.location = location;
		this.email = email;
		this.hPanNo = hPanNo;
		this.is_Active = is_Active;
		this.totalDeluxRoom = totalDeluxRoom;
		this.totalNonDeluxRoom = totalNonDeluxRoom;
		this.bookedRoomNonDelux = bookedRoomNonDelux;
		this.bookedRoomDelux = bookedRoomDelux;
		this.availableDelux = availableDelux;
		this.availableNonDelux = availableNonDelux;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String gethPanNo() {
		return hPanNo;
	}

	public void sethPanNo(String hPanNo) {
		this.hPanNo = hPanNo;
	}

	public Boolean getIs_Active() {
		return is_Active;
	}

	public void setIs_Active(Boolean is_Active) {
		this.is_Active = is_Active;
	}

	public int getTotalDeluxRoom() {
		return totalDeluxRoom;
	}

	public void setTotalDeluxRoom(int totalDeluxRoom) {
		this.totalDeluxRoom = totalDeluxRoom;
	}

	public int getTotalNonDeluxRoom() {
		return totalNonDeluxRoom;
	}

	public void setTotalNonDeluxRoom(int totalNonDeluxRoom) {
		this.totalNonDeluxRoom = totalNonDeluxRoom;
	}

	public int getBookedRoomNonDelux() {
		return bookedRoomNonDelux;
	}

	public void setBookedRoomNonDelux(int bookedRoomNonDelux) {
		this.bookedRoomNonDelux = bookedRoomNonDelux;
	}

	public int getBookedRoomDelux() {
		return bookedRoomDelux;
	}

	public void setBookedRoomDelux(int bookedRoomDelux) {
		this.bookedRoomDelux = bookedRoomDelux;
	}

	public int getAvailableDelux() {
		return availableDelux;
	}

	public void setAvailableDelux(int availableDelux) {
		this.availableDelux = availableDelux;
	}

	public int getAvailableNonDelux() {
		return availableNonDelux;
	}

	public void setAvailableNonDelux(int availableNonDelux) {
		this.availableNonDelux = availableNonDelux;
	}


}