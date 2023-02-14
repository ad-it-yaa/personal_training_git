import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
  return (
    <div>
        <div className="ui inverted segment purple">
  <div className="ui four column grid inverted secondary pointing menu responsive grid">
    <Link className="item column" to="/"  >
      About Us </Link>

    <Link className="item column" to="/contact">
      Contact Us    </Link>

    <Link className="item column" to="/add" onClick={'active'}>
      Add User  </Link>

    <Link className="item column" to="/display">
      Display User  </Link>

  </div>
</div>
    </div>
  )
}
