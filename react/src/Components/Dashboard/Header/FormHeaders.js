import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom';
import './FormHeader.css'
 

export default function FormHeaders() {

  let token = sessionStorage.getItem('token');
  const history = useNavigate();
  const delete_token = () =>
  {
      console.log(token)
      token = sessionStorage.clear('token');
      console.log(token)
      history('../login')
      
  }


  return (

    <div className='form_header'>        
    <img className='form_logo' src='https://seeklogo.com/images/N/nat-west-1969-to-2016-logo-A61F210017-seeklogo.com.png' height={35}></img>
    <div onClick={delete_token}><i className="fas fa-power-off power_button red_colo mvz"></i></div>
    <div className='nav_diva'><NavLink to="/dashboard/moneytransfer"  className='nav_menu active pd'>Money Transfer</NavLink></div>
    <div className='nav_diva'><NavLink to="/dashboard/moviebooking"  className='nav_menu active pd'>Movie Booking</NavLink></div>
    <div className='nav_diva'><NavLink to="/dashboard/merchantpayment"  className='nav_menu active pd'>Merchant Payment</NavLink></div>
            </div>
            
  )
}
