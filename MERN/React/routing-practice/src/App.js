import './App.css';
import Home from './components/Home';
import Routing from './components/Routing';
import {BrowserRouter, Routes, Route} from "react-router-dom";


function App() {
  return (
    <BrowserRouter>
    <div className="App">

      <Routes>
      <Route element={<Home />} path="/home"/>
      <Route element={<Routing />} path="/:word" />
      <Route element={<Routing />} path="/:word/:color/:bgCol" />
      </Routes>

    </div>
    </BrowserRouter>
  );
}

export default App;