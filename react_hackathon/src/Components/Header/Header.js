import React from 'react'
import { NavLink } from 'react-router-dom'

import './Header.css'

export default function () 
{
  
  return (
    <div className='header'>
        
            
            <img className='logo' src='https://www.natwest.com/content/dam/natwest_com/navigation/header/natwest-logo.png' height={22}></img>
            <div className='nav_container'>
            <div className='nav_div'><NavLink to="/home"  className='nav_menu active'>Home</NavLink></div>
            <div className='nav_div'><NavLink to="/about"  className='nav_menu active'>About Us</NavLink></div>
            <div className='nav_div'><NavLink to="/register" className='nav_menu active'>Register</NavLink></div>
            <div className='nav_div'><NavLink className='nav_menu active' to="/login">Login</NavLink></div>
            </div>
            <div className='hamburger'>
              <div className='ham'></div>
              <div className='ham'></div>
              <div className='ham'></div>
            </div>
            
            

            
            
    </div>
  )
}
