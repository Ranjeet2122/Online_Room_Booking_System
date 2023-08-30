import React, { useState, useEffect } from 'react';
import axios from 'axios';

function HotelList() {
  const [hotels, setHotels] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:7070/hotel/hotels')
      .then(response => {
        setHotels(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Hotel List</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Email</th>
            <th>PAN No</th>
            <th>Active</th>
            <th>Total Deluxe Rooms</th>
            <th>Total Non-Deluxe Rooms</th>
            <th>Booked Non-Deluxe Rooms</th>
            <th>Booked Deluxe Rooms</th>
            <th>Available Deluxe Rooms</th>
            <th>Available Non-Deluxe Rooms</th>
          </tr>
        </thead>
        <tbody>
          {hotels.map(hotel => (
            <tr key={hotel.id}>
              <td>{hotel.id}</td>
              <td>{hotel.name}</td>
              <td>{hotel.discription}</td>
              <td>{hotel.location}</td>
              <td>{hotel.email}</td>
              <td>{hotel.hPanNo}</td>
              <td>{hotel.is_Active ? 'Yes' : 'No'}</td>
              <td>{hotel.totalDeluxRoom}</td>
              <td>{hotel.totalNonDeluxRoom}</td>
              <td>{hotel.bookedRoomNonDelux}</td>
              <td>{hotel.bookedRoomDelux}</td>
              <td>{hotel.availableDelux}</td>
              <td>{hotel.availableNonDelux}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default HotelList;
