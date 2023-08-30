import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useHistory } from 'react-router-dom';

function MyBookings() {
  const [bookingDetails, setBookingDetails] = useState([]);
  const [roomType, setRoomType] = useState('');
  const history = useHistory();


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

  const handleUpdateClick = (bookingId) => {
    // set the booking ID in session storage
    sessionStorage.setItem('bookingId', bookingId);
    
    // navigate to the update booking page
    history.push(`/UpdateMyBooking`);
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

  // Get the email from session storage
  const userEmail = sessionStorage.getItem('userName');

  // Filter the bookings based on the user email
  const filteredBookings = bookingDetails.filter((booking) => {
    if (roomType === '') {
      return booking.user.email === userEmail;
    }
    return booking.roomType === roomType && booking.user.email === userEmail;
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
            <th>Update Booking</th>
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
              <td><button onClick={() => handleUpdateClick(booking.id)}>Update Booking</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MyBookings;
