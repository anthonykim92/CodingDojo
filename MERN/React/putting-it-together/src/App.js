import React from 'react';
import './App.css';
import PersonCard from './components/PersonCard'
const people = [
  {
    firstName: "Anthony",
    lastName: "Kim",
    age: 26,
    hairColor: "black",
  },
  {
    firstName: "Lawrence",
    lastName: "Kim",
    age: 13,
    hairColor: "brown",
  },
  {
    firstName: "Andy",
    lastName: "Kim",
    age: 60,
    hairColor: "brown",
  },
  {
    firstName: "Agnes",
    lastName: "Kim",
    age: 53,
    hairColor: "brown",
  },
];
function App() {
  return (
  <div className="App">
    {people.map((personObj, index) => (
        <PersonCard key={index} firstName={personObj.firstName} lastName={personObj.lastName} age={personObj.age} hairColor={personObj.hairColor}/>
        ))}
        </div>
  );
}

export default App;
