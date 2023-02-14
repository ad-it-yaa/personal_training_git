import React, { useEffect } from 'react'
import axios from 'axios'
import './Login.css'
import { useState} from 'react'
import { useFormik } from 'formik'
import { useNavigate } from 'react-router-dom'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Dashboard from '../Dashboard/Dashboard'
import * as yup from 'yup';
export default function Login() {
 
  const token = sessionStorage.getItem('token')

  
  const unamefailure = () => toast(message);
  const loginfailure = () => toast(message);
  const success = () => toast("Login Success");
  const [advertisement, setAdvertisement] = useState([])
  let random = Math.floor(Math.random() * 4);
  const [link,setLink] = useState([])
  const [state,setState] = useState({id:"null",password:"null",token:null})
  let [message,setMessage] = useState()
  useEffect(() => {

    if(token!=null)
    {
return(
  navigate('/dashboard/moneytransfer')
)
}
    fetch('http://localhost:8084/api/awareness/get')
      .then(res => res.json())
      .then(value => {
        setAdvertisement(value)
        setLink(value[random].url);
   
      }
      )
      
    }, [])
    
    

  const navigate = useNavigate();
  const [err,setErr] = useState('')
 
  const formik = useFormik({
    initialValues: {
        id:" ",
        password:" "
    },
    onSubmit: values => {

      fetch('http://localhost:8086/login',
      {
        method:"POST",
        headers:
        {
        'Content-Type':'application/json'
        },
        body:JSON.stringify(values)
      }).then(res=>res.json())
      
          
         
  
        .then(data=>
          {
            if(data.token)
            {
              console.log(data)
              sessionStorage.setItem('token',data.token)
              success();
                          setTimeout(() => {
                            navigate('..dashboard/moneytransfer')    
                          }, 900);

              
            }
            console.log("failuere");
              console.log(data.message);
              message = data.message;
              console.log(message);
              loginfailure(message)
           
            }
          )
      }


  })
  return (
    <div>
      <div className='login_container'>
      <div className='login_heading_container'>
        <div className='login_heading'>
          <p className='login_heading_text'>Internet Banking Login</p>
        </div></div>
        <div className='section_container'>
          <div className='login_section1'>
          <img src={link}/></div>
          <div className='login_section2'>
            <div className='login_section2_header'>Login</div>
            <div className='flex_center'>
            <form onSubmit={formik.handleSubmit}>
      <br/>
      <div className='login_input1'>
                <input type='text' className='input login_input' name='id' id='id' onSubmit={formik.handleSubmit} onChange={formik.handleChange}></input>
                <label className='form_placeholder_login'>Email<span className='mandatory'>*</span></label>
              </div>
        
      <div className='login_input1'>
            <input type='password' className='input login_input' name='password' id='password' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></input>
            <label className='form_placeholder_login'>Password<span className='mandatory'>*</span></label>
      </div>
      <button type='submit' className='login_submit'>Submit</button>
      <br/>
      <br/>
      <span className='pda'>New user?<a href='./register' className='pdad'>Register</a></span>
      </form>
      <ToastContainer
      style={{ width: "400px" }}
position="bottom-right"
autoClose={5000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
limit={1}
/>
    </div>
    </div>

        </div>
      </div>
      <br/>
      <br/>
    </div>
  )
}
