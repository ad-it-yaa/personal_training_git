
import { useFormik } from 'formik'
import React, { useState} from 'react'
import {useHistory} from 'react-router-dom'


export default function Login() {
   
  const history = useHistory();
  const [err,setErr] = useState('')

  const formik = useFormik({
      initialValues: {
          id:'',
          password:''
      },
      onSubmit: values => {
          fetch(`http://localhost:3001/auth?id=${values.id}`)
              .then(res => res.json())
              .then(obj =>
                {
                  
                  if(obj.length===0) {
                      alert('username does not exist')
                  } else {
                      if(obj[0].password === values.password) {
                          alert('User successfully logged in')
                          sessionStorage.setItem('token',obj[0].id)
                          console.log("Login ok");
                          history.push('./news')
                      } else {
                          alert('check your credentials')
                      }
                  }
              })
              .catch(error => setErr(error.message))
      }

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
        <label>Password:</label>
        <input type="text" placeholder='Enter your password' id="password" name='password' onChange={formik.handleChange} onBlur={formik.handleBlur}/><span className='red'>*</span>
        {
            formik.errors.password && formik.touched.password ?<div className='ui red basic label'>{formik.errors.password}</div>:null
        }        
      </div>
      <button type='submit'>Submit</button></form>
    </div>
  )
}
