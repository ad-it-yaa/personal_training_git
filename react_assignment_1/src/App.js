import logo from './logo.svg';
import './App.css';
import Header from './Header/Header';
import Footer from './Footer/Footer';
import { BrowserRouter, Routes, Route} from 'react-router-dom';
import About from './About/About';
import Contact from './Contact/Contact';
import Add from './Add/Add';
import Display from './Display/Display';
import { ErrorBoundary } from 'react-error-boundary';
import Error from './Error/Error';
import axios from 'axios';
 
function App() {
  return (
    <div>
        <BrowserRouter>
          <Header />
          <ErrorBoundary FallbackComponent={Error}>
            <Routes>
              <Route path="/contact" element={<Contact />} />
              <Route path="/add" element={<Add />} />
              <Route path="/display" element={<Display />} />
              <Route path='/' element={<About  />} />
              <Route path='*' element={<Error  />} />
            </Routes>
            </ErrorBoundary>
            <Footer />
          </BrowserRouter>    
       
    </div>
  );
}

export default App;
