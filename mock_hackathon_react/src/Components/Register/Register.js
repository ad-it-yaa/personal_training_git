import axios, { Axios } from 'axios'
import { useFormik } from 'formik'
import React, { useEffect, useState } from 'react'

export default function Register() {  
  const [err,setErr] = useState('')
  const data = () =>
    axios.get('http://localhost:3001/userlist')
      .then(res=>res.data)

  const validation = () =>
  {
    data()
  }
  
  console.log(data)
  const formik = useFormik(
    {
      initialValues:
      {
        fname:'',
        lname:'',
        id:'',
        add:'',
        pincode:'',
        email:'',
        phone:'',
        pass:''
      },
      onSubmit:values=>
      {
      if(1+1==2)
      {
      axios.post('http://localhost:3001/userlist',values)
      .then(res => console.log(res.data))
      .catch(error=> setErr(error.message))
          }    }}
  )

  return (
    <div>
      <form onSubmit={formik.handleSubmit}>
      <div>
      <label>Firstname: </label>
      <input type='text' placeholder='Enter firstname' id='fname'  onChange={formik.handleChange} name='fname'  ></input>
      </div>
      <div>
      <label>Lastname: </label>
      <input type='text' placeholder='Enter Lastname' id='lname'onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Username: </label>
      <input type='text' placeholder='Enter Username' id='id' onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Address: </label>
      <input type='text' placeholder='Enter Address' id='add' onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Pincode: </label>
      <input type='text' placeholder='Enter Pincode' id='pincode' onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Email: </label>
      <input type='text' placeholder='Enter Email'  id='email' onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Phonenumber: </label>
      <input type='text' placeholder='Enter Phonenumber' id='phone' onChange={formik.handleChange}></input>
      </div>
      <div>
      <label>Password: </label>
      <input type='password' placeholder='Enter Password' id='pass' onChange={formik.handleChange}></input>
      </div>
      <button type="submit">Submit</button>
      </form>
    </div>
  )
}
