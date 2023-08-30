import axios from 'axios';
import { useState } from 'react';


const AddRoom = () => {
  const [message, setMessage] = useState('');
  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:7070/hotel/addRoom", {
        discription: event.target.elements.discription.value,
        feedback: event.target.elements.feedback.value,
        pricePerDay: event.target.elements.pricePerDay.value,
        room_Type: event.target.elements.roomType.value,
        hotelId: 1
      });

      console.log(response.data);
      setMessage('Room added successfully!');
    } catch (error) {
      console.error(error);
      setMessage('Failed to add room');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="discription">Description</label>
        <input type="text" id="discription" name="discription" required />
      </div>
      <div>
        <label htmlFor="feedback">Feedback</label>
        <input type="text" id="feedback" name="feedback" required />
      </div>
      <div>
        <label htmlFor="pricePerDay">Price Per Day</label>
        <input type="number" step="0.01" id="pricePerDay" name="pricePerDay" required />
      </div>
      <div>
        <label htmlFor="roomType">Room Type</label>
        <select id="roomType" name="roomType" required>
          <option value="">-- Select Room Type --</option>
          <option value="DELUX">Deluxe</option>
          <option value="NON_DELUX">Non-Deluxe</option>
        </select>
      </div>
      <button type="submit">Add Room</button>
      {message && <p style={{color: message.includes('success') ? 'green' : 'red'}}>{message}</p>}
    </form>
  );
};

export default AddRoom;
