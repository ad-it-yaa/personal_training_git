import logo from './logo.svg';
import './App.css';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Components/Login/Login';
import Register from './Components/Register/Register';
import AboutUs from './Components/AboutUs/AboutUs';
import Home from './Components/Home/Home';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Header />
      <Routes>
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/aboutus' element={<AboutUs/>}/>
        <Route path='*' element={<Home/>}/>
        </Routes>
      
      <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
