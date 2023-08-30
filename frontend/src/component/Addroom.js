import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Home() {
  const [hotels, setHotels] = useState([]);
  const [newRoom, setNewRoom] = useState({
    hotelId: '',
    roomNumber: '',
    roomType: '',
    price: ''
  });

  useEffect(() => {
    axios.get('/api/hotels')
      .then(response => setHotels(response.data))
      .catch(error => console.log(error));
  }, []);

  const handleAddRoom = () => {
    axios.post('/api/rooms', newRoom)
      .then(response => {
        // Add the new room to the hotels array
        const updatedHotels = hotels.map(hotel => {
          if (hotel.id === newRoom.hotelId) {
            return {
              ...hotel,
              rooms: [...hotel.rooms, response.data]
            };
          }
          return hotel;
        });
        setHotels(updatedHotels);

        // Reset the new room form
        setNewRoom({
          hotelId: '',
          roomNumber: '',
          roomType: '',
          price: ''
        });
      })
      .catch(error => console.log(error));
  };

  return (
    <div>
      <h1>Hotel Listings</h1>
      <ul>
        {hotels.map(hotel => (
          <li key={hotel.id}>
            <h2>{hotel.name}</h2>
            <p>{hotel.location}</p>
            <p>{hotel.price_per_night}</p>
            <h3>Rooms</h3>
            <ul>
              {hotel.rooms.map(room => (
                <li key={room.id}>
                  <p>Room number: {room.roomNumber}</p>
                  <p>Room type: {room.roomType}</p>
                  <p>Price: {room.price}</p>
                </li>
              ))}
            </ul>
            <h3>Add a Room</h3>
            <form onSubmit={handleAddRoom}>
              <label>
                Room number:
                <input type="text" value={newRoom.roomNumber} onChange={event => setNewRoom({ ...newRoom, roomNumber: event.target.value })} />
              </label>
              <br />
              <label>
                Room type:
                <input type="text" value={newRoom.roomType} onChange={event => setNewRoom({ ...newRoom, roomType: event.target.value })} />
              </label>
              <br />
              <label>
                Price:
                <input type="text" value={newRoom.price} onChange={event => setNewRoom({ ...newRoom, price: event.target.value })} />
              </label>
              <br />
              <button type="submit">Add Room</button>
            </form>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Home;
