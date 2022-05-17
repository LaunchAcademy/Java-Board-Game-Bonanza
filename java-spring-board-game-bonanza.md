Welcome to board game bonanza! We need a way to track our overflowing inventory of board games. You have been provided with the necessary Thymeleaf templates and a Seeder class.

## Getting Started

```no-highlight
dropdb board_games_development
createdb board_games_development
et get java-spring-board-game-bonanza
cd java-spring-board-game-bonanza
idea .
```

## Core Tasks

### Create the table

- Create a migration that will generate a `board_games` table that has a required unique `name` and an optional `description`.
- Ensure that the table was created successfully before moving on.

### Make the corresponding Entity

- Create a `BoardGame` entity that is linked to the `board_games` table.
- Make sure to use the correct annotations and double-check the import statements when there are multiple libraries to choose from.

### Get that Seeder running!

- Go ahead and uncomment out the code in `BoardGameSeeder`. It looks like it's dependent upon a `BoardGameService` class which doesn't exist yet. Go ahead and create the service along with a `BoardGameRepository` interface.
- Create any additional methods that you need to get the seeder running as it is.
- Once it is running you can check the database in your `psql` terminal to see that the correct records have been persisted.

### Board Games Index Page

```no-highlight
When I navigate to /board-games
I want to see a list of all the board games available
so that I can get a general idea of what game I may want to play
```

- Now that we have records stored in our database, let's take advantage of the provided template to get that information populated up on our webpage.
- Create a `boardGamesController` that will handle requests to `/board-games`.
- Make a `findAll()` method on the service that can be used to get a List of all board games.
- Use the template in `/resources/templates/boardGames/index.html`.
- Pay attention to the type of objects that the templates are expecting.

### Board Games Show Page

```no-highlight
When I navigate to /board-games/{id}
I want to see information about a specific board game
so that I can make a final decision about what to play
```

- Use the template in `/resources/templates/boardGames/show.html`.
- Make a `findById()` method on the service that can be used to get a specific board game with the `id` passed in as an argument.
- Again pay attention to the type of objects and variable names that the view page is expecting.

### Board Games Form Page

```no-highlight
When I navigate to /board-games/new
I want to see a form for a new board game
so that I can add new board games to the list
```

- Use the template in `/resources/templates/boardGames/new.html`.
- First handle the loading of the form page at `/board-games/new`.
- When a form is submitted, the new submission should be persisted to the database.
- Afterwards the user should be redirected back to the index page at `/board-games` and they should see the newly added board game.

### Custom Repository Methods

- Time for some practice writing custom query methods!
- The goal of this step is to get comfortable creating your own query methods that take advantage of the JPA named queries available and maybe even use `@Query` to write your own SQL string.
- Update your `BoardGame` service and repository with new methods that can accomplish the tasks below. After creating a method be sure to test it out to make sure it's returning the data that you expect!:

  - A method to return a specific `BoardGame` by name
  - A method to return all `BoardGame`'s whose name doesn't contain the word "opoly"
  - A method to return all `BoardGame`s whose name ends with "s"
  - A method to return all `BoardGame`s in alphabetical order
  - A method to return all `BoardGame`s in reverse alphabetical order
  - A method to return all `BoardGame`s who have a `name` greater than 6 characters
  - A method to return all `BoardGame`s who have a `name` less than 6 characters

## Non-Core

```no-highlight
As the developer of board game bonanza
I want to create api endpoints for the board games
so that other developers can make requests to get board game data.
```

### API endpoints

- You will need to read ahead to do the following challenges. Only attempt these if all the above core criteria has been completed.
- Create a REST controller to handle requests to `/api/v1/board-games`
- A request to `/api/v1/board-games` should return a JSON response of a list of all the board games stored in the database.
- A request to `/api/v1/board-games/{id}` should return a JSON response of the board game with the `id` used in the request.
