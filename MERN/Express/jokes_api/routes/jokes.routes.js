const JokeController = requre ("../controllers/jokes.controllers")


module.exports = app => {
    app.get('/api/jokes', JokeController.findAllJokes );
    app.get('/api/jokes', JokeController.createNewJoke );
    app.get('/api/jokes/:id', JokeController.findOneJoke)
    app.get('/api/jokes/:id', JokeController.updateExistingJoke );
    app.get('/api/users/:id', JokeController.deleteAnExistingJoke)
}