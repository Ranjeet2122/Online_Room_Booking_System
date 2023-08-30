import { useState, useEffect } from 'react';
import axios from 'axios';
import './Profile.css';

const Profile = () => {
  const [user, setUser] = useState(null);
  const email = sessionStorage.getItem('userName');

  useEffect(() => {
    axios.get('http://localhost:7070/users/getAllUsers')
      .then(response => {
        const users = response.data;
        const matchingUser = users.find(u => u.email === email);
        setUser(matchingUser);
        console.log(email);
      })
      .catch(error => {
        console.log(error);
      });
  }, [email]);

  if (!user) {
    return <div>No data founddd</div>;
  }

  return (
    <div className="profile-container">
      <div className="profile-card">
        <h1>Profile</h1>
        <p><strong>ID:</strong> <span className="id">{user.id}</span></p>
        <p><strong>Name:</strong> <span className="name">{user.name}</span></p>
        <p><strong>Email:</strong> <span className="email">{user.email}</span></p>
        <p><strong>Phone:</strong> <span className="phone">{user.phone}</span></p>
        <p><strong>Address:</strong> <span className="address">{user.address}</span></p>
        <p><strong>Role:</strong> <span className="role">{user.role}</span></p>
        <p><strong>Gender:</strong> <span className="gender">{user.gender}</span></p>
        <p><strong>Date:</strong> <span className="date">{user.date}</span></p>
      </div>
    </div>
  );
};

export default Profile;
