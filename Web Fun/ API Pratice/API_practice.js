const button = document.querySelector('.btn'); 
const jokeText= document.querySelector('.demo');
    
button.addEventListener('click', dadJoke);

function dadJoke() {
    const myHeaders = new Headers();
    
    myHeaders.append('Accept', 'application/json');
    const jokeData = fetch("https://icanhazdadjoke.com", {headers : myHeaders})
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            console.log(data['joke']);
            jokeText.innerHTML = data['joke'];
        })
}

// dadJoke(jokeText)