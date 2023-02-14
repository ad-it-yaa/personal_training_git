import { Button, TextField } from '@mui/material'
import { Stack } from '@mui/system'
import './User.css'
import React from 'react'
import { useFormik } from 'formik'
import * as yup from "yup";
import { useNavigate } from 'react-router-dom'

export default function Login() {
  const navigate =useNavigate();
  const formik = useFormik({
    initialValues: 
    {
        id:"",
        password:""
    },
    onSubmit: values =>
    {
      fetch(`http://localhost:3001/User?id=${values.id}`)
      .then(res => res.json())
      .then(obj =>
        {    if(obj.length == 1)
          {
           
            if(obj[0].id == values.id && obj[0].password == values.password)
            {
                alert("logged-in")
                navigate('../dashboard')
            }
            else
            {
              alert("Incorrect Credentials")
            }
          } 
          else
          {
            alert("User does not exists")
          }
          })},

    validationSchema: yup.object().shape(
      {
       
        password: yup.string().required('Password cannot be empty'),
        id: yup.string().required("User ID cannot be blank")
          
      }
    )
  
})

  return (
    <div>Login
      <div className='form'>
      <div className='form_content'>
      <form onSubmit={formik.handleSubmit}>
      <Stack spacing={2}>
      <TextField id="id"  name="id" label="User ID*" type="number" value={formik.values.id} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.id && Boolean(formik.errors.id)} helperText={formik.touched.id && formik.errors.id}/>
      <TextField id="password"  name='password' label="Password*" type="password" value={formik.values.password} onChange={formik.handleChange} onBlur={formik.handleBlur} error={formik.touched.password && Boolean(formik.errors.password)} helperText={formik.touched.password && formik.errors.password} />
      <Button variant="contained" size="large" color="primary" type="submit">
        Login
      </Button>
      </Stack>
      </form>
      <br/>
      </div>
      
      <br/>
    </div>
    </div>)
    }