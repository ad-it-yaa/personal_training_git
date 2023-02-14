import React from 'react'
import './Moviebooking.css'
export default function Moviebooking() {
  return (
    <div className='container'>
    <br/>
    <div className="card-group mx-3">
    <div className="card flex">
    <img height={300} src="https://media.istockphoto.com/photos/two-orange-movie-tickets-isolated-on-a-white-background-picture-id536016669?k=20&m=536016669&s=612x612&w=0&h=8mc4_u-ycZxkxPQ9DzMpMVgtQQwzxT84aGeXGe0tUvc=" className="card-img-top width" alt="..."/>
    <div className="card-body">
      <h5 className="card-title">Movie Booking</h5>
      <p className="card-text md-3">Natwest offers showtimes, movie tickets, reviews, trailers, concert tickets and events near you. Also features promotional offers, coupons.</p>
      <p className="card-text mt-8"><small className="text-muted">Get 10% Flat Discount for payments above £50</small></p>
    </div>
</div>
</div>
<br/>
</div>
  )
}
