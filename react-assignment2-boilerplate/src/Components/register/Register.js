import React, { useState }  from 'react'
import { useFormik } from 'formik';
import* as yup from 'yup';
import './register.css'

export default function Register() {

  
  const [err,setErr] = useState('');
  const formik = useFormik( {
    
    initialValues: 
    {
      id:'',
      email:'',
      password:'',
      phone:''
    },
    onSubmit: values => {
      fetch('http://localhost:3001/auth',
      {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(values)
      })
      .then (result => { alert('User Registered')
          
    })
    .catch(error => setErr(error.message));
      console.log(values)
    },
    validationSchema: yup.object().shape(
      {
        id:  yup.string().required('ID cannot be blank'),
         
        password: yup.string()
                          
                          .min(8,'Password must have minimum 8 characters with one letter in capital and one special character')
                          .matches(/[A-Z]/,'Password must have minimum 8 characters with one letter in capital and one special character')
                          .matches(/[^\w]/, 'Password must have minimum 8 characters with one letter in capital and one special character')
                          .required('Password cannot be empty'),                   
        phone: yup.string().min(10).max(10,'Phone number should be 10 digits')
                               .required('Enter valid phone number'),
                          
        email: yup.string().email('Enter a valid Email')
                          .required("Email cannot be blank")
                        }
    )
  })

  return (
    <div>
     <br/>
     <form onSubmit={formik.handleSubmit}>
        <div>
          <label>Username:</label>
          <input type="text" placeholder='Enter your username' id="id" onChange={formik.handleChange} onBlur={formik.handleBlur}/><span className='red'>*</span>
        {
          formik.errors.id && formik.touched.id ?<div className='ui red basic label'>{formik.errors.id}</div>:null
        }
        </div>
        <div>
          <label>Email:</label>
          <input type="text" placeholder='Enter your email' id="email" onChange={formik.handleChange} onBlur={formik.handleBlur}/><span className='red'>*</span>
        {
          formik.errors.email && formik.touched.email ?<div className='ui red basic label'>{formik.errors.email}</div>:null
        }
        </div>
        <div>
          <label>Password:</label>
          <input type="text" placeholder='Enter your password' id="password" name='password' onChange={formik.handleChange} onBlur={formik.handleBlur}/><span className='red'>*</span>

        {
          formik.errors.password && formik.touched.password ?<div className='ui red basic label'>{formik.errors.password}</div>:null
        }        </div>
        <div>
          <label>Phone number:</label>
          <input type="number" placeholder='Enter your Phone Number' id="phone" onChange={formik.handleChange} onBlur={formik.handleBlur}/><span className='red'>*</span>
        {
          formik.errors.phone && formik.touched.phone ?<div className='ui red basic label'>{formik.errors.phone}</div>:null
        }
        </div>
        <div>
          <button>Submit</button>
        </div>
        </form>
    </div>

  )
}
