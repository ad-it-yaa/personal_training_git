import React, { useEffect } from 'react'
import './Login.css'
import { useState} from 'react'
import { useFormik } from 'formik'
import { useNavigate } from 'react-router-dom'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Dashboard from '../Dashboard/Dashboard'
export default function Login() {
 
  const token = sessionStorage.getItem('token')
  
  
  const unamefailure = () => toast("User does not exist");
  const loginfailure = () => toast("Incorrect Credentials");
  const success = () => toast("Login Success");
  const [advertisement, setAdvertisement] = useState([])
  let random = Math.floor(Math.random() * 4);
  const [link,setLink] = useState([])
  useEffect(() => {
    fetch('http://localhost:3001/image')
      .then(res => res.json())
      .then(value => {
        setAdvertisement(value)
        setLink(value[random].url1);
      }
      )
      
      
    }, [])
    

  const navigate = useNavigate();
  const [err,setErr] = useState('')
 
  const formik = useFormik({
    initialValues: {
        id:'',
        password:''
    },
    onSubmit: values => {
        fetch(`http://localhost:3001/login?id=${values.id}`)
            .then(res => res.json())
            .then(obj =>
              {
              
                
                if(obj.length===0) {
                  unamefailure()
                } else {
                    if(obj[0].password === values.password) {
                        sessionStorage.setItem('token',obj[0].id)
                        sessionStorage.setItem('card',obj[0].card)
                        sessionStorage.setItem('name',obj[0].name)
                        success();
                        setTimeout(() => {
                          navigate('../dashboard')    
                        }, 900);
                        
                        
                    } else {
                      loginfailure()                       
                    }
                }
            })
            .catch(error => setErr(error.message))
    }


  })
if(token!=null)
{
return(
  navigate('/dashboard')
)
}
else
{
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
}