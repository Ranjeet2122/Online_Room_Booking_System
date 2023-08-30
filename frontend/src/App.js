import React from "react";
import { Link, Switch, Route, useHistory } from "react-router-dom";
import SigninScreen from "./screens/SigninScreen";
import RegisterScreen from "./screens/RegisterScreen";
import ForgotPasswordScreen from "./screens/ForgotPasswordScreen";
import VerifyOtp from "./screens/verifyOTP";
import ResetPass from "./screens/ResetPass";

import axios from "axios";
import useAuthHelper from "../src/hooks/useAuthHelper";
import { useEffect, useState } from "react";
import Home from "./screens/Users/Home";
import Payment from "./screens/Users/Payment";
import Addroom from "./screens/Admin/Addroom";

import './App.css';
import BookARoom from "./screens/Users/BookARoom";
import Admin from "./screens/Admin/Admin";

import UserList from "./screens/Admin/UserList";
import Profile from "./screens/Profile";
import BookingDetails from "./screens/Admin/BookingDetails";

import ShowAllRooms from "./screens/Admin/ShowAllRooms";
import HotelList from "./screens/Admin/HotelList";
import MyBookings from "./screens/MyBookings";
import UpdateMyBooking from "./screens/UpdateMyBooking";




  // var [userName, setuserName] = useState("Guest");
  
  
  function App() {
    const { setSessionStorage, isLoggedIn, getSessionStorage, clearStorage } =
    useAuthHelper();
  const [i, setI] = useState("true"); // fix variable initialization and state
  const history = useHistory();
    const signOutClick = () => {
     
      clearStorage();
      history.push("/Home");
      window.location.reload();

    };
  
    const toHome = () => {
  
    };

  var logf = () => {
    // debugger;
    if (i == getSessionStorage("isLogin")) {
      return (
        <>
          <div className="dropdown">
            {getSessionStorage("userName")}
            <Link to="#">
              <i className="fa fa-caret-down"></i>{" "}
            </Link>
            <ul className="dropdown-content">
              <li>
                <Link to="/MyBookings">My Bookings</Link>
              </li>
              <li>
                <Link to="/profile">My Profile</Link>
              </li>
              <li>
                <button  onClick={signOutClick }>Sign Out</button>

              </li>
            </ul>
          </div>
        </>
      );
    } else {
      return (
        <>
          {/* console.Write(isLogin); */}
          <Link to="/signin">Sign In</Link>
        </>
      );
    }
  };
  return (
    <div className="grid-container">
      <header className="row">
        <div>
          <Link className="brand" to="/home">
            Home
          </Link>
        </div>

        <div>
          <Link className="logo" to="/home">
            StrangerX
          </Link>
        </div>
        {logf()}
        {/* {window.location.reload(true)} */}
        {/* <div>
          <Link className="brand" to="/signin">
            <Link></Link>
            Sign In
          </Link>
        </div> */}
      </header>

      <Switch>
        {/* <Route path="/signin" component={SigninScreen} signin={signin}></Route> */}
       
        <Route path="/register" component={RegisterScreen}></Route>
        <Route path="/Home" component={Home}></Route>
        <Route path="/Admin" component={Admin}></Route>
        <Route path="/verifyOtp" component={VerifyOtp}></Route>
        <Route path="/ResetPass" component={ResetPass}></Route>
        <Route path="/Payment" component={Payment}></Route>
        <Route path="/addroom" component={Addroom}></Route>
        <Route path="/BookARoom" component={BookARoom}></Route>
        <Route path="/BookingDetails" component={BookingDetails}></Route>
        <Route path="/ShowAllRooms" component={ShowAllRooms}></Route>
        <Route path="/BookARoom" component={BookARoom}></Route>
        <Route path="/Payment" component={Payment}></Route>
        <Route path="/HotelList" component={HotelList}></Route>
        <Route path="/UpdateMyBooking" component={UpdateMyBooking}></Route>

        <Route path="/MyBookings" component={MyBookings}></Route>
        {/* <Route path="/ResetPass" element={<ResetPass />} > */}

        <Route path="/Profile" component={Profile}></Route>
       
        <Route path="/UserList" component={UserList}></Route>
        <Route path="/forgot" component={ForgotPasswordScreen}></Route>
        {<Route path="/signin" component={SigninScreen}></Route>}
        <Home/>
      </Switch>


      {/* <h1>Frontend</h1> */}
      <footer className="row center">
        Contact Us :
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Email : strangerx@gmail.com
      </footer>
    </div>
  );
}

export default App;
