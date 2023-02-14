import React, { useState } from 'react'
import './AccountSumary.css'
export default function AccountSumary() {
    const session = sessionStorage.getItem('token')
    const [id,setId] = useState('')
    const [name,setName] = useState('')
    const [address,setAddress] = useState('')
    const [account,setAccount] = useState('')
    const [phone,setPhone] = useState('')
    const [amount,setAmount] = useState('')
    const [card,setCard] = useState('')

    const data = fetch(`https://nat-api.onrender.com/login?id=${session}`)
        .then(res => res.json())
        .then(obj =>{
            setId(obj[0].id)
            setName(obj[0].name)
            setAddress(obj[0].address)
            setAccount(obj[0].account)
            setPhone(obj[0].phone)
            setAmount(obj[0].amount)
            setCard(obj[0].card)
            

        })
    
  return (
    <div className='summary_container'>
        
        <div className='summary'>
        <center><h2>Account Sumary</h2></center>
        <div className='summarise'>    
        <div className='summary_heading'>
        <h5>Accountholder Name:</h5>
        <h5>Card Number:</h5>
        <h5>Account Balance:</h5>
        <h5>Email ID:</h5>
        <h5>Address:</h5>
        
        <h5>Account Number:</h5>
        <h5>Phone Number:</h5>

        </div>
        <div className='summary_content'>
        <h5>{name}</h5>
        <h5>XXXX XXXX XXXX {card}</h5>
        <h5>£ {amount}</h5>
        <h5>{id}</h5>
        <h5>{address}</h5>
        <h5>{account}</h5>
        <h5>{phone}</h5>
        </div>
        </div>
        <br/>
    </div>
    </div>
  )
}
