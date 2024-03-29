import React from 'react'
import { NavLink } from 'react-router-dom'

export default function Header() {
  return (
    <div><nav className="navbar navbar-expand-lg navbar-dark bg-dark">
    <a className="navbar-brand" >Logo</a>
    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div className="navbar-nav">
        <NavLink className="nav-item nav-link"  to="/main">Home</NavLink>
        <NavLink className="nav-item nav-link"  to="/login">Login</NavLink>
        <NavLink className="nav-item nav-link"  to="/register">Register</NavLink>
        <NavLink className="nav-item nav-link disabled" to="/news">News</NavLink>
      </div>
    </div>
  </nav></div>
  )
}


