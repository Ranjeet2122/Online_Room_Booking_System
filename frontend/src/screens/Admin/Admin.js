import React from 'react';
import { Route, Switch, Link } from 'react-router-dom';
import Addroom from './Addroom';
import RoomDetails from './RoomDetails';
import Bookings from './Bookings';
import BookingDetails from './BookingDetails';
import MyBookings from '../MyBookings';

export default function Admin() {
  return (
    <div>
      <h1>Hotel Manager App</h1>
      <nav>
        <ul>
          <li>
            <Link to="/addroom" >Add Room</Link>
          </li>
        </ul>
      </nav>
      <nav>
        <ul>
          <li>
            <Link to="/UserList" >Show All Users</Link>
          </li>
        </ul>
      </nav>

      <nav>
        <ul>
          <li>
            <Link to="/ShowAllRooms" >Show All Rooms</Link>
          </li>
        </ul>
      </nav>
      <nav>
        <ul>
          <li>
            <Link to="/HotelList" >Show Hotels</Link>
          </li>
        </ul>
      </nav>
    
      <Switch>
        <Route path="/addroom" component={Addroom} />

      </Switch>
      <BookingDetails/>
    </div>
  );
}
