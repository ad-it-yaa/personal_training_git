import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import About_Us from "./Components/About Us/About_Us";
import Admin from "./Components/Admin/Admin";
import Contact_Us from "./Components/Contact Us/Contact_Us";
import Dashboard from "./Components/Dashboard/Dashboard";
import Dasbhboard_Content from "./Components/Dashboard/Dashboard_Content/Dasbhboard_Content";
import EMICalculator from "./Components/EMI Calculator/EMICalculator";
import Enquire from "./Components/Enquire/Enquire";
import Footer from "./Components/Footer/Footer";
import ForgotPassword from "./Components/ForgotPassword/ForgotPassword";
import Header from "./Components/Header/Header";
import Home from "./Components/Home/Home";
import Login from "./Components/Login/Login";
import OurProducts from "./Components/Our Products/OurProducts";
import Register from "./Components/Register/Register";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      {window.location.pathname !== "/admin" && <Header />}
        <Routes>
          <Route path="" element={<Home />}></Route>
          <Route path="/aboutus" element={<About_Us />}></Route>
          <Route path="/ourproducts" element={<OurProducts />}></Route>
          <Route path="/emicalculator" element={<EMICalculator />}></Route>
          <Route path="/enquire" element={<Enquire />}></Route>
          <Route path="/contactus" element={<Contact_Us />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/login/register" element={<Register />}></Route>
          <Route
            path="/login/resetpassword"
            element={<ForgotPassword />}
          ></Route>
          <Route path="/dashboard/*" element={<Dashboard />}></Route>
          <Route path="/admin" element={<Admin />}></Route>
        </Routes>
        {window.location.pathname !== "/admin" && <Footer />}
      </BrowserRouter>
    </div>
  );
}

export default App;
