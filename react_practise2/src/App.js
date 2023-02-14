import logo from './logo.svg';
import './App.css';
import { BrowserRouter , Routes, Route } from 'react-router-dom';
import { Suspense } from 'react';
import Home from './Home/Home';
import AddUser from './AddUser/AddUser';
import Login from './Login/Login';
import Dashboard from './Dashboard/Dashboard';
import Header from './Header/Header';
import PageNotFound from './PageNotFound/PageNotFound';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Suspense fallback={<div><h2>Loading...</h2></div>}>
          <Header />
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/adduser' element={<AddUser />} />
            <Route path='/login' element={<Login />} />
            <Route path='/dashboard' element={<Dashboard />} />
            <Route path='/home' element={<Home />} />
            <Route path='*' element={<PageNotFound />} />
          </Routes>
        </Suspense>
      </BrowserRouter>
    </div>
  );
}

export default App;
