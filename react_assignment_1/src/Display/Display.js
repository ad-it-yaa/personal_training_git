import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function Display() {
  const navigate = useNavigate();

  const [array, setarray] = useState([]);
  const [err,setErr] = useState('')

  useEffect(() => {
    axios.get('http://localhost:3001/userlist')
      .then(result => setarray(result.data))
      .catch(error => setErr(error.message))
  },[]) 

  const Deleteuser = (id) => {
    
  
    
    axios.delete(`http://localhost:3001/userlist/${id}`)
          .then(result => {
            alert('Record deleted');
            window.location.reload()
          })
          .catch(error => setErr(error.message))

  }

  return (
    <div className='ui segment centered responsive grid'>
      <div className='ui card ui three item menu'>
      <h2>User List</h2>
      <div className=''>
          <span>{err}</span>
            
      </div>
      
        <center><div className="">
            <table className='ui responsive' border={'2em'}>
              <thead>
                <tr>
                
                  <th>Email ID</th>
                  <th>Firstname</th>
                  <th>Lastname</th>
                  <th>Phonenumber</th>
                  <th>City</th>
                  <th>Pincode</th>
                  <th>Action</th>
                </tr>
                
              </thead>
              <tbody>
                {
                  array.map(data => 
                  <tr key={data.id}>
                  
                    <td>{data.id}</td>
                    <td>{data.fname}</td>
                    <td>{data.lname}</td>
                    <td>{data.phone}</td>
                    <td>{data.city}</td>
                    <td>{data.pincode}</td>
                   <td><button onClick={Deleteuser.bind(this,data.id)} className=''>Delete</button></td>
                  </tr>
                  )
                }
              </tbody>
            </table>
            
        </div>
        </center>
        <br/>
        </div>
      </div>
  
)}