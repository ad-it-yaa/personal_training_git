import * as yup from "yup";
import { Button, FormControl, FormControlLabel, FormLabel, TextField } from '@mui/material'
import { Stack } from '@mui/system'
import { useFormik } from 'formik';
import React from 'react'
import './Enquire.css'
export default function Enquire() {
    const formik = useFormik({
        initialValues: {
            id:"",
            address:"",
            phone:"",
            email:"",
            message:"",

        },
        onSubmit: values =>
        {
                         
                fetch("http://localhost:8000/Enquire",
                {
                  method:"POST",
                  headers: { 'Content-Type': 'application/json' },
                  body: JSON.stringify(values)
                })
                .then(result=> {
                  console.log(result)
                })
              },

        validationSchema: yup.object().shape(
          {
            id: yup.string().required("Customer name cannot be blank"),
            address: yup.string().required("Address cannot be blank"),
            phone: yup.string().required("Phone number cannot be blank")
            .min(10, "Please enter a valid phone number")
            .max(10, "Please enter a valid phone number"),
            email: yup.string().email("Enter a valid Email")
            .required("Email cannot be blank"),
            message: yup.string().required("Message cannot be blank")
  
              }
        )
      
    })


  return (
    <div>Enquire
        <div className='form'>
            <div className='form_content'>
                <form onSubmit={formik.handleSubmit}>
                <Stack spacing={1}>
                <TextField id="id" name="id" label="Customer Name*" value={formik.values.id} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.id && Boolean(formik.errors.id)} helperText={formik.touched.id && formik.errors.id}/>
                <TextField id="address" name="address" label="Address*" rows={4} multiline value={formik.values.address} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.address && Boolean(formik.errors.address)} helperText={formik.touched.address && formik.errors.address}/>
                <TextField id="phone"   name="phone" label="Phone Number*" type="number" value={formik.values.phone} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.phone && Boolean(formik.errors.phone)} helperText={formik.touched.phone && formik.errors.phone}/>
                <TextField id="email"   name="email" label="Email ID*" type="email" value={formik.values.email} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.email && Boolean(formik.errors.email)} helperText={formik.touched.email && formik.errors.email} />
                <TextField id="message" name="message" label="Message*" rows={4} multiline value={formik.values.message} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.Message && Boolean(formik.errors.Message)} helperText={formik.touched.Message && formik.errors.Message}/>
                <Button variant="contained" size="large" color="primary" type="submit">
                  Submit
                </Button>
                </Stack>
                </form>
            </div>   
        </div>
        <br/>
    </div>
  )
}

