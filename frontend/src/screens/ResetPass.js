import { useState } from "react";
import config from "../config";
import axios from "axios";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import { useHistory } from "react-router-dom";
//import { grey, red } from "@mui/material/colors";

const ResetPass = () => {
  //const navigate = useNavigate();
  const history = useHistory();
  const [password, setNewPass] = useState("");
  const [reEnterPass, setEnterPass] = useState("");

  const RequestForReset = () => {
    let email = sessionStorage.getItem("email");
    console.log(password);
    console.log(email);
    const body = {
      email,
      password,
    };

    if (password == reEnterPass) {
      console.log(body);
      const url = config.serverURL + `/resetPassword`;
      axios.post(url, body).then((response) => {
        const result = response.data;
        if (result["status"] == "success") {
          //navigate("/signin");
          history.push("/signin");
          toast.info("Password changed successfully");
        } else {
          toast.error(result.error);
        }
      });
    }
  };

  return (
    <div>
      <center>
        <table>
          <center>
            <tr>
              <td>
                <h4>Enter new Password :</h4>
              </td>
              <td>
                <input
                  type={"text"}
                  onChange={(e) => {
                    setNewPass(e.target.value);
                  }}
                ></input>
              </td>
            </tr>

            <tr>
              <td>
                <h4 style={{ color: "white" }}>Re-Enter Password :</h4>
              </td>
              <td>
                <input
                  type={"text"}
                  onChange={(e) => {
                    setEnterPass(e.target.value);
                  }}
                ></input>
              </td>
            </tr>
            <tr>
              <td>
                <button onClick={RequestForReset}>Reset</button>
              </td>
            </tr>
          </center>
        </table>
      </center>
    </div>
  );
};

export default ResetPass;
