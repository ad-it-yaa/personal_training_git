import { Button, TextField } from "@mui/material";
import { Stack } from "@mui/system";
import { useFormik } from "formik";
import React, { useEffect, useState } from "react";
import * as yup from "yup";
import "./Apply_loan.css";
import axios from "axios";
import "react-toastify/dist/ReactToastify.css";
import { toast, ToastContainer } from "react-toastify";
import { confirmAlert } from "react-confirm-alert";
import "react-confirm-alert/src/react-confirm-alert.css";
import { useNavigate } from "react-router-dom";

export default function Apply_loan() {
  const id = sessionStorage.getItem("id");
  const token = sessionStorage.getItem("token");
  const [loan, setLoan] = useState([]);
  const [appliedcount, setAppliedcount] = useState([]);
  const [cancelcount, setCancelcount] = useState([]);
  const [validation, setValidation] = useState([]);
  const navigate = useNavigate();
  console.log(appliedcount);
  console.log(cancelcount);
  const creditscore = Math.floor(Math.random() * (850 - 300 + 1)) + 300;
  useEffect(() => {
    const fetchData = async () => {
      try {
        const id = sessionStorage.getItem("id");
        const res = await axios.get("http://localhost:8080/api/loan/get",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });
        setLoan(res.data.filter((item) => item.custid === parseInt(id)));
        setAppliedcount(
          loan.filter((loan) => loan.status === "Applied").length
          
        )
        setValidation(true);
        setCancelcount(loan.filter((loan) => loan.status === "cancel").length);
      } catch (err) {
        console.log(err);
        setValidation(false);
      }
    };
    fetchData();
  }, [appliedcount,cancelcount]);

  let timestamp = Date();
  const formik = useFormik({
    initialValues: {
      address: "",
      applytime: timestamp,
      approved: "",
      creditscore: creditscore,
      custid: id,
      income: "",
      interest: "",
      loanamt: "",
      loantenure: "",
      occupation: "",
      offer: "",
      propertyrate: "",
      status: "Applied",
      tin: "",
      underwriting: "",
      updatedbyemp: "",
      updatetime: "",
      valuation: "",
    },
    onSubmit: (values) => {
      confirmAlert({
        customUI: ({ onClose }) => {
          return (
            <div className="custom-ui">
              <h1>Submit Request?</h1>
              <p>Do You want to submit this request?</p>
              <button onClick={onClose}>No</button>
              <button
                onClick={() => {
                  exe();
                  onClose();
                }}
              >
                Yes
              </button>
            </div>
          );
        },
      });
      const exe = () => {
        if (appliedcount < 1 && cancelcount < 3) {
        const config = {
        headers: {
        Authorization: `Bearer ${token}`
        }
        };
        axios
        .post(`http://localhost:8080/api/loan/add`, values, config)
        .then((res) => console.log(res.data));
        toast.success("Request Successfully Submitted!", {
        position: "bottom-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: 0,
        theme: "dark"
        });
        setTimeout(() => {
          navigate("/loan_status");
        }, 2000)
        } else {
        toast.error(
        "Loan application limit reached, Please try after 15 days.",
        {
        position: "bottom-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored"
      }
      );
    }
  };
},

    validationSchema: yup.object().shape({
      propertyrate: yup.string().required("Cannot be blank").matches(/^\d+$/, "Invalid property rate"),
      loanamt: yup.string().required("Cannot be blank").matches(/^\d+$/, "Invalid loan amount"),
      loantenure: yup.string().required("Cannot be blank").matches(/^\d+$/, "Invalid loan tenure").max(25, "Loan tenure cannot exceed 25"),
      income: yup.string().required("Cannot be blank").matches(/^\d+$/, "Invalid income"),
      occupation: yup.string().required("Cannot be blank").min(3, "Occupation must be at least 3 characters"),
      tin: yup.string().required("Cannot be blank").matches(/^\d{9}$/, "TIN must be 9 digits"),
      address: yup.string().required("Cannot be blank").min(10, "Address must be at least 10 characters"),
    }),
  });
if(validation==true)
  return (
    <div className="loan_container">
      <div className="loan_form_container">
        <div className="loan_form_header">
          <br />
          <form onSubmit={formik.handleSubmit}>
            <Stack spacing={2}>
              <TextField
                id="propertyrate"
                name="propertyrate"
                label="Property Cost / Estimate*"
                type="number"
                value={formik.values.propertyrate}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={
                  formik.touched.propertyrate &&
                  Boolean(formik.errors.propertyrate)
                }
                helperText={
                  formik.touched.propertyrate && formik.errors.propertyrate
                }
              />
              <TextField
                id="loanamt"
                name="loanamt"
                label="Loan Amount*"
                type="number"
                value={formik.values.loanamt}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.loanamt && Boolean(formik.errors.loanamt)}
                helperText={formik.touched.loanamt && formik.errors.loanamt}
              />
              <TextField
                id="loantenure"
                name="loantenure"
                label="Loan Tenure*"
                type="number"
                value={formik.values.loantenure}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={
                  formik.touched.loantenure && Boolean(formik.errors.loantenure)
                }
                helperText={
                  formik.touched.loantenure && formik.errors.loantenure
                }
              />
              <TextField
                id="income"
                name="income"
                label="Annual Income*"
                type="number"
                value={formik.values.income}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.income && Boolean(formik.errors.income)}
                helperText={formik.touched.income && formik.errors.income}
              />
              <TextField
                id="occupation"
                name="occupation"
                label="Occupation*"
                type="text"
                value={formik.values.occupation}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={
                  formik.touched.occupation && Boolean(formik.errors.occupation)
                }
                helperText={
                  formik.touched.occupation && formik.errors.occupation
                }
              />
              <TextField
                id="tin"
                name="tin"
                label="TIN ID.*"
                type="text"
                value={formik.values.tin}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.tin && Boolean(formik.errors.tin)}
                helperText={formik.touched.tin && formik.errors.tin}
              />
              <TextField
                id="address"
                name="address"
                label="Address*"
                rows={4}
                multiline
                value={formik.values.address}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.address && Boolean(formik.errors.address)}
                helperText={formik.touched.address && formik.errors.address}
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
        </div>
      </div>
    </div>
  )
  else
  {
    navigate("/login");
  }
}
