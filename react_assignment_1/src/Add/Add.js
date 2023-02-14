import axios from 'axios'
import { Formik, useFormik } from 'formik'
import React, { useState } from 'react'
import * as yup from 'yup'
import './add.css'

export default function Add() {
  const [err,setErr] = useState('');
  const formik = useFormik( {
    
    initialValues: 
    {
      id:'',
      pass:'',
      repass:'',
      fname:'',
      lname:'',
      phone:'',
      city:'',
      pincode:'',
    },
    onSubmit: values => {
      axios.post('http://localhost:3001/userlist', values)
      .then (result => { alert('User Registered')
          
    })
    .catch(error => setErr(error.message));
      console.log(values)
    },
    validationSchema: yup.object().shape(
      {
        id:  yup.string().email('Enter a valid email')
               .required('ID cannot be blank'),
               fname: yup.string()
               .required('First name cannot be blank'),

        pass: yup.string()
                          
                          .min(8,'Password must have minimum 8 characters with one letter in capital and one special character')
                          .matches(/[A-Z]/,'Password must have minimum 8 characters with one letter in capital and one special character')
                          .matches(/[^\w]/, 'Password must have minimum 8 characters with one letter in capital and one special character')
                          .required('Password cannot be empty'),                    
        repass: yup.string().label('confirm password').required().oneOf([yup.ref('pass'), null], 'Passwords must match'),
  
        lname: yup.string().required('Enter lastname'),
        phone: yup.string().min(10).max(10,'Phone number should be 10 digits')
                               .required('Enter valid phone number')
                               
                               ,
        city: yup.string().required('Enter your city'),
        pincode: yup.string().min(6).max(6,'Enter Valid PINCODE')
                        }
    )
  })

  return (
    <div className='ui card  ui three item menu'>
    <div className='center aligned  column'>Add
      <form onSubmit={formik.handleSubmit}>
    <div className='ui responsive'>      
      <label className='label'>Email ID :</label>
          <input type="text" placeholder='Enter your email' id="id" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.id && formik.touched.id ?<div className='ui red basic label'>{formik.errors.id}</div>:null
        }
        <br/>
        <label>Password :</label>
        <input type="text" placeholder='Enter your password' id="pass" name='pass' onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.pass && formik.touched.pass ?<div className='ui red basic label'>{formik.errors.pass}</div>:null
        }
        <br/>
        <label>Re-enter Password :</label>
        <input type="password" placeholder='Re-enter your password' id="repass" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.repass && formik.touched.repass ?<div className='ui red basic label'>{formik.errors.repass}</div>:null
        }
        <br/>
        <label>Firstname :</label>    
        <input type="text" placeholder='Enter your firstname' id="fname" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.fname && formik.touched.fname?<div className='ui red basic label'>{formik.errors.fname}</div>:null
        }       
        <br/>
        <label>Lastname :</label>
        <input type="text" placeholder='Enter your lastname' id="lname" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.lname && formik.touched.lname ?<div className='ui red basic label'>{formik.errors.lname}</div>:null
        }
        <br/>
        <label>Phone :</label>
        <input type="number" placeholder='Enter your Phone Number' id="phone" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.phone && formik.touched.phone ?<div className='ui red basic label'>{formik.errors.phone}</div>:null
        }
        <br/>
        <label>City :</label>
        <input type="text" placeholder='Enter your city' id="city" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
         {
          formik.errors.city && formik.touched.city?<div className='ui red basic label'>{formik.errors.city}</div>:null
        }
        <br/>
        <label>Pincode :</label>
        <input type="number" placeholder='Enter your pincode' id="pincode" onChange={formik.handleChange} onBlur={formik.handleBlur}/>
        {
          formik.errors.pincode && formik.touched.pincode ?<div className='ui red basic label'>{formik.errors.pincode}</div>:null
        }
        <br/>
        <button type="submit">Submit</button>      
        </div>
      </form>
    </div>
   </div> 
  )
}
