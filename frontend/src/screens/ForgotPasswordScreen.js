import { useState } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';

function ForgetPasswordScreen() {
  const [email, setEmail] = useState('');
  const [otpSent, setOtpSent] = useState(false);
  const history = useHistory();

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await axios.post('http://localhost:7070/users/resetPassword', { email });
      setOtpSent(true);
    } catch (error) {
      console.error(error);
    }
  };

  const handleVerifyOTP = () => {
    history.push('/verifyOTP');
  };

  return (
    <div>
      <h1>Reset Password</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Email:
          <input type="email" value={email} onChange={handleEmailChange} required />
        </label>
        <button type="submit">Send OTP</button>
      </form>
      {otpSent && (
        <div>
          <p>OTP sent successfully!</p>
          <button onClick={handleVerifyOTP}>Verify OTP</button>
        </div>
      )}
    </div>
  );
}

export default ForgetPasswordScreen;
