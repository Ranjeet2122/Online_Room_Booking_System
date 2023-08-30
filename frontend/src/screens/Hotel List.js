import React, { useState, useEffect } from 'react';
import axios from 'axios';

function HotelList() {
  const [hotels, setHotels] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:7070/hotel/hotels')
      .then(response => setHotels(response.data))
      .catch(error => console.log(error));
  }, []);

  return (
    <div>
      <h1>Hotel Listings</h1>
      <ul>
        {hotels.map(hotel => (
          <li key={hotel.id}>
            <h2>{hotel.name}</h2>
            <p>{hotel.location}</p>
            <p>{hotel.price_per_night}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default HotelList;
