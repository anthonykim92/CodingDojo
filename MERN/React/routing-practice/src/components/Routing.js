import React from 'react';
import { useParams } from 'react-router-dom';


const Routing = (props) =>{
    const {word, color, bgCol} = useParams();

    return(
        <div>
                isNaN(word)?
                <p style= {color? {color: color, backgroundColor: bgCol}:null}>
                    Word: {word}
                </p>
                :
                <p>
                    Number: {word}
                </p>
        </div>
    )
};
export default Routing