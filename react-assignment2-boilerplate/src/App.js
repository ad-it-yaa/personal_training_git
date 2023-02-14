import React from 'react'
import {BrowserRouter,Route,Switch} from 'react-router-dom'
import Dashboard from './Components/dashboard/Dashboard'
import Footer from './Components/footer/Footer'
import Header from './Components/header/Header'
import Login from './Components/login/Login'
import Register from './Components/register/Register'
export default function App() {
  return (
    <div>
      <BrowserRouter>
      <Header />
      <Switch>
      <Route path='/news'><Dashboard/></Route>
      <Route path='/login'><Login/></Route>
      <Route path='/register'><Register/></Route>
      <Route path='*'><div /></Route>
            </Switch>
      <Footer />
      </BrowserRouter>
    </div>
  )
}
