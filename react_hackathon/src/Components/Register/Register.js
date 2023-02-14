import React, { Component, useEffect, useState } from 'react'
import './Register.css'
import { useFormik } from 'formik';
import * as yup from 'yup';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';

export default function Register() {
  let cardnumber = Math.floor(Math.random()*10000);
  let amount = Math.floor(Math.random()*10000);
  amount = amount.toFixed(2);
  const cardnum = ()=>
  {
    if(cardnumber>1000)
    {
      return cardnumber;
    }
    else
    {
      cardnumber = cardnumber + 1000;
      return cardnumber
    }
  }
  cardnum();
  const navigate = useNavigate();
  const success = () => toast("Registration Success!");
  const failure = () => toast("User already exist");
  const [advertisement, setAdvertisement] = useState([])
  const [link,setLink] = useState([])
  useEffect(() => {
    fetch('http://localhost:3001/image')
      .then(res => res.json())
      .then(value => {
        setAdvertisement(value)
        setLink(value[random].url);
      }
      )
      
      
    }, [])


let random = Math.floor(Math.random() * 5);

  const [err, setErr] = useState('');

  const formik = useFormik({

    initialValues:
    {
      id: '',
      name: '',
      address: '',
      account: '',
      phone: '',
      password: '',
      card: cardnumber,
      amount: amount

    },
    onSubmit: values => {

      let checkuser = fetch(`http://localhost:3001/login?id=${values.id}`)
        .then(res => res.json())
        .then(obj => {
          if (obj.length == 0) {

            fetch('http://localhost:3001/login',
              {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(values)
              })
              .then(result => {
                success();
                setTimeout(() => {
                  navigate('../login')    
                }, 1500);

              })
              .catch(error => setErr(error.message));
          } else {
            failure()
          }
        })


    },
    validationSchema: yup.object().shape(
      {
        name: yup.string().required('Username cannot be blank'),
        address: yup.string().required("Address cannot be blank"),
        account: yup.string().required("Account number cannot be empty")
          .max(10, "Account number should be of 10 digits").min(10, "Account number should be of 10 digits"),
        password: yup.string()

          .min(8, 'Password must have minimum 8 characters with one letter in capital and one special character')
          .matches(/[A-Z]/, 'Password must have minimum 8 characters with one letter in capital and one special character')
          .matches(/[^\w]/, 'Password must have minimum 8 characters with one letter in capital and one special character')
          .required('Password cannot be empty'),
        phone: yup.string().min(10).max(10, 'Phone number should be 10 digits')
          .required('Enter valid phone number'),
        id: yup.string().email('Enter a valid Email')
          .required("Email cannot be blank")

      }
    ),
    validateOnChange: false



  })


  return (
    <div>
      <div>
        <div className='error_container'>
        </div>
      </div>
      <div className='register_main_container'>
        <div className='section2'>

          <div className='registration_container'>
            <div className='register_heading'><p className='register_headtext'>Registration Form</p></div>
          </div>
          <div className='form'>
            <form onSubmit={formik.handleSubmit}>
              <div>
                <input type='text' className='input' name='id' id='id' onSubmit={formik.handleSubmit} onChange={formik.handleChange}></input>
                <label className='form_placeholder'>Email<span className='mandatory'>*</span></label>
                {
                  formik.errors.id && formik.touched.id ? <div className='red'>{formik.errors.id}</div> : null
                }
              </div>
              <div>
                <input type='text' className='input' name='name' id='name' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></input>
                <label className='form_placeholder'>Username<span className='mandatory'>*</span></label>
                {
                  formik.errors.name && formik.touched.name ? <div className='red'>{formik.errors.name}</div> : null
                }
              </div>
              <div>
                <textarea rows="5" className='input' name='address' id='address' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></textarea>
                <label className='form_placeholder1'>Address<span className='mandatory'>*</span></label>
                {
                  formik.errors.address && formik.touched.address ? <div className='red'>{formik.errors.address}</div> : null
                }
              </div>
              <div>
                <input type='text' className='input' name='account' id='account' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></input>
                <label className='form_placeholder'>Account No.<span className='mandatory'>*</span></label>
                {
                  formik.errors.account && formik.touched.account ? <div className='red'>{formik.errors.account}</div> : null
                }
              </div>
              <div>
                <input type='number' className='input' name='phone' id='phone' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></input>
                <label className='form_placeholder'>Phone Number<span className='mandatory'>*</span></label>
                {
                  formik.errors.phone && formik.touched.phone ? <div className='red'>{formik.errors.phone}</div> : null
                }

              </div>
              <div>
                <input type='password' className='input' name='password' id='password' onSubmit={formik.handleSubmit} onChange={formik.handleChange} ></input>
                <label className='form_placeholder'>Password<span className='mandatory'>*</span></label>
                {
                  formik.errors.password && formik.touched.password ? <div className='red'>{formik.errors.password}</div> : null
                }
              </div>
              <br />
              <button type='submit' className='submit'>Submit</button>
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
            </form>

          </div>
        </div>
        <div className='section1'>
          <div className='image_section1'>
          <img src={link}/></div>
        </div>


      </div>
      <br/>
    </div>

  )
}
