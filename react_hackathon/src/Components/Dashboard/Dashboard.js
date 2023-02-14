import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Error from '../Error/Error';
import Login from '../Login/Login';
import AccountSumary from './AccountSumary/AccountSumary';
import Card from './Card/Card';
import FormHeaders from './Header/FormHeaders'
import Medicine from './Medicine/Medicine';
import Moneytransfer from './Moneytransfer/Moneytransfer';
import Moviebooking from './Moviebooking/Moviebooking';


export default function Dashboard() {
    let token = sessionStorage.getItem('token');
    
    if(token!=null)
    {
    return (
    <div>
      <FormHeaders/>
      <Card/>
      <AccountSumary/>
      <Routes>
        <Route path='moneytransfer' element={<Moneytransfer/>}/>
        <Route path='moviebooking' element={<Moviebooking/>}/>
        <Route path='merchantpayment' element={<Medicine/>}/>
        
        </Routes>  
        
    </div>
  )
}
else{
    return(
        <Login/>
      );

}
}
