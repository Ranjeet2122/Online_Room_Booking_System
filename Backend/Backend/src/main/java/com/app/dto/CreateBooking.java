package com.app.dto;


public class CreateBooking {
	private int noofBooked;
	private String checkInDate;
	private String checkOutDate;
	private int numGuests;
	private String roomType;
//	private int totalPrice;
  private Long bookingHotel;
    private String  userId;
    
    public CreateBooking() {
		// TODO Auto-generated constructor stub
	}

//	public CreateBooking(int noofBooked, String checkInDate, String checkOutDate, int numGuests, String roomType,
//			Long hotelId, Long userId) {
//		super();
//		NoofBooked = noofBooked;
//		this.checkInDate = checkInDate;
//		this.checkOutDate = checkOutDate;
//		this.numGuests = numGuests;
//		this.roomType = roomType;
//		this.HotelId = hotelId;
//		this.userId = userId;
//	}
    
    public CreateBooking(int noofBooked, String checkInDate, String checkOutDate, int numGuests, String roomType,
    		Long bookingHotel, String userId) {
    	super();
    	this.noofBooked = noofBooked;
    	this.checkInDate = checkInDate;
    	this.checkOutDate = checkOutDate;
    	this.numGuests = numGuests;
    	this.roomType = roomType;
    	this.bookingHotel = bookingHotel;
    	this.userId = userId;
    }
  
	public int getNoofBooked() {
		return noofBooked;
	}
	

	public void setNoofBooked(int noofBooked) {
		this.noofBooked = noofBooked;
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


	public Long getBookingHotel() {
		return bookingHotel;
	}

	public void setBookingHotel(Long bookingHotel) {
		this.bookingHotel = bookingHotel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
         
}