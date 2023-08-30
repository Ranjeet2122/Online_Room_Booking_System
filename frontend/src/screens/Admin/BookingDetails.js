import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './admin.css';

const BookingDetails = () => {
  const [bookingDetails, setBookingDetails] = useState([]);
  const [roomType, setRoomType] = useState('');

  useEffect(() => {
    axios.get('http://localhost:7070/booking/detail')
      .then(response => {
        setBookingDetails(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleRoomTypeChange = (event) => {
    setRoomType(event.target.value);
  };

  const handleCancelBooking = (bookingId) => {
    axios.post(`http://localhost:7070/booking/cancalation/${bookingId}`)
      .then(response => {
        const updatedBookings = bookingDetails.filter(booking => booking.id !== bookingId);
        setBookingDetails(updatedBookings);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const filteredBookings = bookingDetails.filter((booking) => {
    if (roomType === '') {
      return true;
    }
    return booking.roomType === roomType;
  });

  return (
    <div>
      <h1>Booking Details</h1>
      <form>
        <div>
          <label htmlFor="roomType">Filter by Room Type:</label>
          <select id="roomType" value={roomType} onChange={handleRoomTypeChange}>
            <option value="">All</option>
            <option value="DELUX">Delux</option>
            <option value="NON_DELUX">Non-Delux</option>
          </select>
        </div>
      </form>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>User email id</th>
            <th>Name</th>
            <th>Check-in Date</th>
            <th>Check-out Date</th>
            <th>Number of Guests</th>
            <th>Room Type</th>
            <th>No. of Booked Rooms</th>
            
            <th>Cancel Booking</th>
          </tr>
        </thead>
        <tbody>
          {filteredBookings.map((booking) => (
            <tr key={booking.id}>
              
              <td>{booking.id}</td>
              <td>{booking.user.email}</td>
              <td>{booking.user.name}</td>
              <td>{booking.checkInDate}</td>
              <td>{booking.checkOutDate}</td>
              <td>{booking.numGuests}</td>
              <td>{booking.roomType}</td>
              <td>{booking.noofBooked}</td>
             
              <td><button className="cancel-button" onClick={() => handleCancelBooking(booking.id)}>Cancel Booking</button></td>

            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BookingDetails;
