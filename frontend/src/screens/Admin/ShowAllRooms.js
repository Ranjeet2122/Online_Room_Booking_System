import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ShowAllRooms() {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:7070/hotel/getRoomByHotel/1')
      .then(response => {
        setRooms(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>All Rooms</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Room Type</th>
            <th>Price Per Day</th>
            <th>Feedback</th>
          </tr>
        </thead>
        <tbody>
          {rooms.map(room => (
            <tr key={room.id}>
              <td>{room.id}</td>
              <td>{room.discription}</td>
              <td>{room.room_Type}</td>
              <td>{room.pricePerDay}</td>
              <td>{room.feedback}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ShowAllRooms;
