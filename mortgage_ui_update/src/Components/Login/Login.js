import { Button, TextField } from "@mui/material";
import { Stack } from "@mui/system";
import "./Login.css";
import React, { useEffect, useState } from "react";
import { useFormik } from "formik";
import * as yup from "yup";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function Login() {
  const [loan, setData] = useState([]);
  const invalidcredentials = () => toast("Incorrect Credentials");
  const navigate = useNavigate();
  const sestoken = sessionStorage.getItem("token");
  console.log("sestoken: ", sestoken);
  useEffect(() => {
    // if (sestoken !== null) {
    //   navigate("/dashboard");
    // }
  }, [sestoken]);
  const formik = useFormik({
    initialValues: {
      custid: "",
      password: "",
      token: "",
    },
    onSubmit: (values) => {
      axios
        .post("http://localhost:8082/login", {
          custid: values.custid,
          password: values.password,
        })
        .then((res) => {
          let token = res.data.token;
          let cid = res.data.cid;
          sessionStorage.setItem("token", token);
          localStorage.setItem("id", cid);
          sessionStorage.setItem("id", cid);
          axios
            .get(`http://localhost:8080/api/register/get/${cid}`, {
              headers: {
                Authorization: `Bearer ${token}`,
              },
            })
            .then((res) => {
              toast.success("Login Success", {
                position: "bottom-right",
                autoClose: 2000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: 0,
                theme: "dark",
              });
              setTimeout(() => {
                navigate("/dashboard/");
              }, 2000);
            })
            .catch((err) => {
              console.log(err.response.data.message);
            });
        })
        .catch((error) => {
          console.log(error.response.data.message);
          toast.error("Incorrect Credentials!", {
            position: "bottom-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "colored",
          });
        });
    },

    validationSchema: yup.object().shape({
      password: yup.string().required("Password cannot be empty"),
      custid: yup.string().required("Customer ID cannot be blank"),
    }),
  });
  if (sestoken == null) {
    return (
      <div>
        Login
        <div className="form">
          <div className="form_content">
            <form onSubmit={formik.handleSubmit}>
              <Stack spacing={2}>
                <TextField
                  id="custid"
                  name="custid"
                  label="Customer ID*"
                  type="number"
                  value={formik.values.custid}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                  error={formik.touched.custid && Boolean(formik.errors.custid)}
                  helperText={formik.touched.custid && formik.errors.custid}
                />
                <TextField
                  id="password"
                  name="password"
                  label="Password*"
                  type="password"
                  value={formik.values.password}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                  error={
                    formik.touched.password && Boolean(formik.errors.password)
                  }
                  helperText={formik.touched.password && formik.errors.password}
                />
                <Button
                  variant="contained"
                  size="large"
                  color="primary"
                  type="submit"
                >
                  Login
                </Button>
                <ToastContainer
                  position="bottom-right"
                  autoClose={5000}
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
            </form>
            <br />
          </div>
        </div>
        <div className="flx_row">
          <a href="/login/register">New User? Register</a>
          <a href="/login/resetpassword">Forgot Password</a>
        </div>
        <br />
      </div>
    );
  } else {
    navigate("/dashboard/");
    console.log("navigate: ", navigate);
  }
}
