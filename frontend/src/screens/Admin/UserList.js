import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './UserList.css'; // import the CSS file

function UserList() {
  const [users, setUsers] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    axios.get('http://localhost:7070/users/getAllUsers')
      .then(response => {
        setUsers(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const filteredUsers = users.filter(user => {
    return user.email.toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div className="container">
      <h1>User List</h1>
      <div className="search-container">
        <input
          type="text"
          placeholder="Search by email"
          value={searchTerm}
          onChange={(event) => setSearchTerm(event.target.value)}
        />
      </div>
      <br/>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Role</th>
            <th>Gender</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {filteredUsers.map(user => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.phone}</td>
              <td>{user.address}</td>
              <td>{user.role}</td>
              <td>{user.gender}</td>
              <td>{user.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserList;
