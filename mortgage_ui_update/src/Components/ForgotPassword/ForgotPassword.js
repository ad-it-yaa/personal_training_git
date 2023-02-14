import { Button, TextField } from "@mui/material";
import { Stack } from "@mui/system";
import axios from "axios";
import { useFormik } from "formik";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import * as yup from "yup";
import "./ForgotPassword.css";

export default function ForgotPassword() {
  const [unlock_password, setUnlock_password] = useState(false);
  const [lock_submit, setlock_submit] = useState(false);
  const [lock_userfields, setLock_userfields] = useState(false);
  const [data, setData] = useState([]);
  const navigate = useNavigate();
  let timestamp = Date();

  const formik = useFormik({
    initialValues: {
      email: "",
      custid: "",
      pin: "",
      password: null,
      confirm_password: null,
      modifiedAt: timestamp,
    },
    onSubmit: (values) => {
      console.log("SSS");
      axios
        .get(`http://localhost:8080/api/register/get/${values.custid}`)
        .then((response) => {
          if (response.status == 200 && response.data.email == values.email) {
            axios.post(`http://localhost:8080/api/register/checkpin`,
             {
                custid: values.custid,
                pin: values.pin,
              })
              .then((response) => {
                if (response.data == true) {
                  alert("authenticated");
                  setUnlock_password(true);
                  setlock_submit(true);
                  setLock_userfields(true);
                  if(values.password==values.confirm_password && values.password!=null)
                  {
                    axios.put(
                      `http://localhost:8080/api/register/update/${values.custid}`,
                      {
                        password: values.password,
                        modifiedAt: values.modifiedAt,
                      }
                    ).then(toast.success("Registration Successful!", {
                      position: "bottom-right",
                      autoClose: 2000,
                      hideProgressBar: false,
                      closeOnClick: true,
                      pauseOnHover: true,
                      draggable: true,
                      progress: 0,
                      theme: "dark"
                      }),
                      setTimeout(() => {
                        navigate("/login");
                      }, 2000)
                    )
                    
                  }
                  else
                  {
                    toast.error(
                      "Password not Matching",
                      {
                      position: "bottom-right",
                      autoClose: 5000,
                      hideProgressBar: false,
                      closeOnClick: true,
                      pauseOnHover: true,
                      draggable: true,
                      progress: undefined,
                      theme: "colored"
                    })
                  }
                 
                  
                } else if (
                  response.status == 200 &&
                  response.email != values.email
                ) {
                  toast.error(
                    "Invalid Credentials",
                    {
                    position: "bottom-right",
                    autoClose: 5000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "colored"
                  })
                }
                console.log(response.data);
              })
              .catch((error) => console.log(error));
          } else {
            toast.error(
              "Invalid Credentials",
              {
              position: "bottom-right",
              autoClose: 5000,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
              theme: "colored"
            })
          }
        })
        .catch((error) => {
          toast.error(
            "Invalid Credentials",
            {
            position: "bottom-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "colored"
          })
  
      
        });
    },
   

    validationSchema: yup.object().shape({
      email: yup.string().email("Enter a valid Email")
            .required("Email cannot be blank"),
            custid: yup.string().required("Customer ID cannot be blank"),
            pin: yup.string().required("PIN cannot be blank")
            .min(4,"Enter a valid PIN")
            .max(4,"Enter a valid PIN"),
      //       password: yup.string()
      // // .when("unlock_password", {
      //   is: true, // only apply this validation rule when unlock_password is true
      //   then: yup.string()
      //   .required("Password cannot be blank")
      //   .min(8, "Password must be at least 8 characters long")
      //   .matches(/[a-z]/, "Password must contain at least one lowercase letter")
      //   .matches(/[A-Z]/, "Password must contain at least one uppercase letter")
      //   .matches(/[0-9]/, "Password must contain at least one number")
      //   .matches(/[!@#\$%\^&]/, "Password must contain at least one special character")
      // }),
      //       confirm_password: yup.string().when("unlock_password", {is: true, then: yup.string().required("Password cannot be blank")})
      //       // })
    }),
  });

  return (
    <div>
      <br />
      <div className="form">
        <div className="form_container">
          <form onSubmit={formik.handleSubmit}>
            <Stack spacing={1}>
              <TextField
                id="custid"
                name="custid"
                label="Customer ID*"
                type="number"
                value={formik.values.custid}
                disabled={lock_userfields}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.custid && Boolean(formik.errors.custid)}
                helperText={formik.touched.custid && formik.errors.custid}
              />
              <TextField
                id="email"
                name="email"
                label="Email ID*"
                type="text"
                value={formik.values.email}
                disabled={lock_userfields}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.email && Boolean(formik.errors.email)}
                helperText={formik.touched.email && formik.errors.email}
              />
              <TextField
                id="pin"
                name="pin"
                label="iPIN*"
                type="password"
                value={formik.values.pin}
                disabled={lock_userfields}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.pin && Boolean(formik.errors.pin)}
                helperText={formik.touched.pin && formik.errors.pin}
              />
              {!lock_submit && (
                <Button
                  variant="contained"
                  size="large"
                  color="primary"
                  type="submit"
                >
                  Submit
                </Button>
              )}
              {unlock_password && (
                <div className="form">
                  <div className="form_container">
                    {" "}
                    <Stack spacing={1}>
                      <TextField
                        id="password"
                        name="password"
                        label="Password*"
                        type="password"
                        value={formik.values.password}
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        error={
                          formik.touched.password &&
                          Boolean(formik.errors.password)
                        }
                        helperText={
                          formik.touched.password && formik.errors.password
                        }
                      />
                      <TextField
                        id="confirm_password"
                        name="confirm_password"
                        label="Confirm Password*"
                        type="password"
                        value={formik.values.confirm_password}
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        error={
                          formik.touched.confirm_password &&
                          Boolean(formik.errors.confirm_password)
                        }
                        helperText={
                          formik.touched.confirm_password &&
                          formik.errors.confirm_password
                        }
                      />
                      <Button
                        variant="contained"
                        size="large"
                        color="primary"
                        type="submit"
                      >
                        Submit
                      </Button>
                      <ToastContainer
                position="bottom-right"
                autoClose={2000}
                limit={1}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="colored"
              />
                    </Stack>
                  </div>
                </div>
              )}
            </Stack>
          </form>
        </div>
      </div>
    </div>
  );
}
