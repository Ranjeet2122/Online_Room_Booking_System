import React from "react";
import { useFormInputValidation } from "react-form-input-validation";
import { useHistory, Link } from "react-router-dom";
import axios from "axios";
import useAuthHelper from "../hooks/useAuthHelper";
import ForgotPasswordScreen from "./ForgotPasswordScreen";
import RegisterScreen from "./RegisterScreen";

const SigninScreen = () => {
  var history = useHistory();
  var admin = 1;


  var { setSessionStorage } = useAuthHelper();
  const [fields, errors, form] = useFormInputValidation(
    {
      email: "",
      password: "",
    },
    {
      email: "required|email",

      password: "required",
    }
  );

  const onSubmit = async (event) => {
    debugger;
    const isValid = await form.validate(event);


    if (isValid) {
    
      axios
        .post("http://localhost:7070/users/login", {
          email: fields.email,
          password: fields.password,
          
        })
        .then(function (response) { debugger;
          if (
            fields.email == response.data.email 
            //fields.password == response.data.password
          ) {
            setSessionStorage("userName", response.data.email);
          
            setSessionStorage("token", "1234");
            setSessionStorage("isLogin", "true");
           sessionStorage.setItem("userId", response.data.id);
            if ("MANAGER" == response.data.role) {
               setSessionStorage("userName", response.data.email);
               setSessionStorage("isLogin", "true");
              history.push("/Admin");
            } else {
              // setSessionStorage("userName", response.data.email);
              // setSessionStorage("token", "1234");
              // setSessionStorage("isLogin", "true");
              history.push("/Home");
              console.log(response);
            }
            window.location.reload(true);
          }
          
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  };

  return (
    <div style={{ maxWidth: "600px", margin: "0 auto" }}>
      <form
        //className="myForm"
        className="form"
        noValidate
        autoComplete="off"
        onSubmit={onSubmit}
      >
        <div>
          <label>
            Email:
            <input
              type="email"
              name="email"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.email}
            />
          </label>
          <label className="error">{errors.email ? errors.email : ""}</label>
        </div>
        <div>
          <label>
            Password:
            <input
              type="password"
              name="password"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.password}
            />
          </label>
          <label className="error">
            {errors.password ? errors.password : ""}
          </label>
        </div>
        <p>
          <button type="submit">Submit</button>
        </p>
      </form>

      <div>
        <span style={{ color: "white" }}>New customer?</span>
        <Link to="/register" style={{ color: "blue" }}>
          Create your account
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </Link>
        <Link to="/forgot" style={{ color: "blue" }}>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Forgot Password
        </Link>
      </div>
    </div>
  );
};

export default SigninScreen;