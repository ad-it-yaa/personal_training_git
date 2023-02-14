import logo from './logo.svg';
import './App.css';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Register from './Components/Register/Register';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Components/Login/Login';
import Dashboard from './Components/Dashboard/Dashboard';
import Home from './Components/Home/Home';
import About from './Components/About/About';
import Error from './Components/Error/Error';

function App() {
  return (

    <div>
      <BrowserRouter>
      <Header/>
      <Routes>
      <Route path='' element={<Home/>}></Route>
      <Route path='/register' element={<Register/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/dashboard/*' element={<Dashboard/>}/>
      <Route path='/about' element={<About/>}/>
      <Route path='*' element={<Error/>}/>
      </Routes>
      <Footer/>
      </BrowserRouter>
    </div>


  );
}

export default App;
