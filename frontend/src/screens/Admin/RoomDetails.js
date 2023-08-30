import React, { useState, useEffect } from 'react';
import axios from 'axios';

function RoomDetails() {
  const [bookings, setBookings] = useState([]);
  const [selectedRoomType, setSelectedRoomType] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:7070/bookings')
      .then(response => {
        setBookings(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  const handleSort = (roomType) => {
    setSelectedRoomType(roomType);
    let sortedBookings = [...bookings];
    sortedBookings.sort((a, b) => {
      if (a.roomType === roomType && b.roomType !== roomType) {
        return -1;
      } else if (a.roomType !== roomType && b.roomType === roomType) {
        return 1;
      } else {
        return 0;
      }
    });
    setBookings(sortedBookings);
  };

  return (
    <>
      <div className="container">
        <h1 className="title">Booking</h1>
        <div className="sort-buttons">
          <button className={selectedRoomType === 'Delux' ? 'active' : ''} onClick={() => handleSort('Delux')}>
            Delux
          </button>
          <button className={selectedRoomType === 'Non-Delux' ? 'active' : ''} onClick={() => handleSort('Non-Delux')}>
            Non-Delux
          </button>
          <button className={selectedRoomType ? '' : 'active'} onClick={() => setBookings([...bookings])}>
            Clear
          </button>
        </div>
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

export default RoomDetails;
