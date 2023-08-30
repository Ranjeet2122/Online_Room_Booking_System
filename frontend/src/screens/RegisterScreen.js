import React, { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import axios from "axios";
import SigninScreenScreen from "./SigninScreen";

function RegisterScreen() {
  const history = useHistory();
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [email, setEmail] = useState("");
  const [gender, setGender] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [phone, setphone] = useState("");
  const [role, setrole] = useState("USER");
  const [birthdate, setBirthdate] = useState("");

  const formatDate = (date) => {
    const d = new Date(date);
    const year = d.getFullYear();
    const month = ("0" + (d.getMonth() + 1)).slice(-2);
    const day = ("0" + d.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setrole("USER");
    console.log(birthdate);
    // Convert birthdate to yyyy-MM-dd format
    const formattedBirthdate = formatDate(birthdate);

    axios
      .post("http://localhost:7070/users/signup", {
        name,
        address,
        email,
        gender,
        password,
        phone,
        role,
        date: formattedBirthdate,
      })
      .then(function (response) {
        history.push("/signin");
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  
  const handleGenderChange = (event) => {
    setGender(event.target.value);
  };

  return (
    <div>
      <form className="form" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            placeholder="Enter name"
            required
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
        </div>

        <div>
          <label htmlFor="address">Address:</label>
          <input
            type="text"
            id="address"
            placeholder="Enter Address"
            required
            value={address}
            onChange={(event) => setAddress(event.target.value)}
          />
        </div>

        <div>
          <label htmlFor="email">Email Address:</label>
          <input
            type="email"
            id="email"
            placeholder="Enter email"
            required
            value={email}
            onChange={(event) => setEmail(event.target.value)}
          />
        </div>

        <div>
          <label htmlFor="gender">Gender:</label>
          <select name="gender" value={gender} onChange={handleGenderChange}>
            <option value="">Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
        </div>

        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            placeholder="Enter password"
            required
            value={password}
            onChange={(event) => setPassword(event.target.value)}
          />
        </div>

        <div>
          <label htmlFor="confirmPassword">Confirm Password:</label>
          <input
            type="password"
            id="confirmPassword"
            placeholder="Enter confirm password"

            onChange={(event) => setConfirmPassword(event.target.value)}
          />
        </div>

        <div>
          <label htmlFor="phone">Mobile Number:</label>
          <input
            type="tel"
            id="phone"
            placeholder="Enter Mobile Number"
            required
            value={phone}
            onChange={(event) => setphone(event.target.value)}
          />
        </div>
        

        <div>
  <label htmlFor="birthdate">Birthdate:</label>
  <input
    type="date"
    id="birthdate"
    placeholder="Enter birthdate"
    required
    value={birthdate}
    onChange={(event) => setBirthdate(event.target.value)}
  />
</div>


        <button type="submit">Register</button>
        <div>
          <label />
          <div style={{ color: "blue" }}>
            Already have an account? <Link to="/signin">Sign-In</Link>
          </div>
        </div>
      </form>
    </div>
  );
}

export default RegisterScreen;
