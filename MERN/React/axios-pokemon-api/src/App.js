import './App.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios'; 

function App() {
  const [pokemon, setPokemonData] = useState([]);
  useEffect(() => {
    axios.get("https://pokeapi.co/api/v2/pokemon?limit=807")
      .then((response) => {console.log(response.data.results);
        setPokemonData(response.data.results);
      })
      .catch((err) => console.log(err)); }, []);
  return (
    <div className="App">
      <ul>
        {pokemon.map((pokemonObj, index)=>{
            return (<li key={index}>{pokemonObj.name}</li>)
          })
        }
      </ul>
    </div>
  );
}

export default App;