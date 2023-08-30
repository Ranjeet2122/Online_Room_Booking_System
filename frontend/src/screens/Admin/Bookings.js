import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Bookings() {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:7070/bookings')
      .then(response => {
        setBookings(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    // <>
    //   {bookings.map(booking => (
    //     <div key={booking.id}>
    //       <p>Booking ID: {booking.id}</p>
    //       <p>Guest Name: {booking.guestName}</p>
    //       <p>Check-in Date: {booking.checkinDate}</p>
    //       <p>Check-out Date: {booking.checkoutDate}</p>
    //       <p>Room Type: {booking.roomType}</p>
    //     </div>
    //   ))}
    // </>

    <>
    <div className="container">
      <h1 className="title">Booking</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Booking ID</th>
            <th>Guest Name</th>
            <th>Check-in Date:</th>
            <th>Check-out Date:</th>
            <th>Delux / Non-Delux</th>
          

          </tr>
        </thead>
        <tbody>
          {bookings.map(booking => (
            <tr key={booking.id}>
              <td>{booking.id}</td>
              <td>{booking.guestName}</td>
              <td>{booking.checkinDate}</td>
              <td>{booking.checkoutDate}</td>
              <td>{booking.roomType}</td>
              
            </tr>
          ))}
        </tbody>
      </table>
    </div>
 
    </>
  );
}

export default Bookings;
