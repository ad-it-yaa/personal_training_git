import React from 'react';
import './App.css';
import Header from './Components/header/Header';
import Dashboard from './Components/dashboard/Dashboard';
import Footer from './Components/footer/Footer';



class App extends React.Component{
  render(){

    return <div className = 'main-content' >
    <Header />
    <Dashboard />
    <Footer />
    </div>
    
   
  }
}
export default App;
