# Back-end side of FilmApp Project
This repository is created to store user data and to create a personalized profile for a mobile application.

This project is valuable as it allows users to securely store their data and create customized profiles for a mobile application, enhancing their overall user experience.

# Begin using this project

1. Clone the repository.
   
```sh
git clone https://github.com/Elokuva-Projekti-2023/BackEndFilmProject.git
```

# Database Schema

The server uses database with the following schema

## Movie

| Name              | Type         |  Relations  |
| -------------     | ----------   |-------------|
| movie_id          | bigint       | PRIMARY KEY |
| movie_title       | varchar(100) |  |
| movie_description | varchar(500) |  |
| movie_genre_ids   |  |  |

## User

| Name                  | Type            |  Relations  |
| -------------         | ----------      |-------------|
| user_id               | bigint          | PRIMARY KEY |
| user_name             | VARCHAR(255)    |             |
| user_email            | VARCHAR(255)    |             |
| user_password         | VARCHAR(255)    |             |

## MovieDetailResponse

| Name              | Type         |  Relations  |
| ----------------- | ------------ |-------------|
| id                | bigint       | PRIMARY KEY |
| overview          | varchar(max) |             |
| release_date      | varchar(20)  |             |
| title             | varchar(100) |             |
| poster_path       | varchar(255) |             |
| original_title    | varchar(100) |             |
| vote_average      | double       |             |
| vote_count        | int          |             |

## AboutToWatchList

| Name                   | Type         |  Relations  |
| ---------------------- | ------------ |-------------|
| aboutToWatchListId     | bigint       | PRIMARY KEY |
| user                   | User         | FOREIGN KEY |
| movies                 | List<Movie>  |             |

## FavoritesList

| Name               | Type         |  Relations  |
| ------------------ | ------------ |-------------|
| favoritesListId    | bigint       | PRIMARY KEY |
| user               | User         | FOREIGN KEY |
| movies             | List<Movie>  |             |

## OnWatchList

| Name              | Type         |  Relations  |
| ----------------- | ------------ |-------------|
| onWatchListId     | bigint       | PRIMARY KEY |
| user              | User         | FOREIGN KEY |
| movies            | List<Movie>  |             |

## UserMovieLists

| Name              | Type             |  Relations         |
| ----------------- | ---------------- |--------------------|
| userMovieListsId  | bigint           | PRIMARY KEY        |
| favoritesList     | FavoritesList    | FOREIGN KEY        |
| aboutToWatchList  | AboutToWatchList | FOREIGN KEY        |
| onWatchList       | OnWatchList      | FOREIGN KEY        |







# API


For this project we have decided to use the TMDB API. On our documentation we have provided a brief overview of the TMDB API and focused on one specific endpoints that we've implemented. The TMDB API offers a wide range of functionalities to fetch info about movies, TV-shows, actors and so on. For more detailed information of the TMDB API, refer to [the official TMDB API documentation](https://developers.themoviedb.org/3/getting-started/introduction) 

## Endpoints

### GET

* [Now playing movies](EndpointDocs/GET/now-playing.md)
* [Popular movies](EndpointDocs/GET/popular.md)
* [Upcoming movies](EndpointDocs/GET/upcoming.md)
* [Top rated movies](EndpointDocs/GET/toprated.md)
* [Search movie](EndpointDocs/GET/searchmovie.md) 
* [Movie by id](EndpointDocs/GET/moviebyid.md)
* [All favorites lists](EndpointDocs/GET/allfavorites.md)
* [All users](EndpointDocs/GET/allusers.md)
* [User's movie lists](EndpointDocs/GET/userslists.md) 

### POST

* [User's registration](EndpointDocs/POST/register.md)
* [User's sign in](EndpointDocs/POST/signin.md)
* [Adding movie to favorites](EndpointDocs/POST/addfavorite.md)
* [Adding movie to watchlist](EndpointDocs/POST/watchlist.md)
* [Adding movie to watched list](EndpointDocs/POST/watchedmovies.md)

### DELETE
* [Delete movie from favorites](EndpointDocs/DELETE/deletefavorite.md)
* [Delete movie from watchlist](EndpointDocs/DELETE/delfromwatchlist.md)
* [Delete movie from watched list](EndpointDocs/DELETE/delfromwatched.md)

# Mobile App
The Front End side of this app you can find [here](https://github.com/Elokuva-Projekti-2023/MobileProject)
