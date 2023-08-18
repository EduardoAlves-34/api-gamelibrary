import { Route, Routes, BrowserRouter } from 'react-router-dom';
import Library from "./pages/Library";
import './css/styles.css';
import logo from './css/Es.svg';


function App() {
  return (
    <div>
      <img src={logo} alt="logo" />
      <p>Loja</p>
      <p>Perfil</p>
      <p>Biblioteca</p>
      <BrowserRouter>
        <Routes>
          <Route exact path='/' element={ <Library/> } />
       </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
