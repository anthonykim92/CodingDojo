import React, { useState } from 'react';
    
const PersonalCard = (props) => {
    const { firstName, lastName, age, hairColor } = props;
    const [stateAge, setStateAge] = useState(props.age); 
    return (
        <div>
            <h1 style={{color:"black"}}>{firstName} {lastName}</h1>
            <p>Age: {stateAge}</p>
            <p>Hair Color: {hairColor} </p>
            <button onClick= {(event) => setStateAge(stateAge + 1)}>Birthday Button for {firstName}</button>
        </div>
    )
}

export default PersonalCard;