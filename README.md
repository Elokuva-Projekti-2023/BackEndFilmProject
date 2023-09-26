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


## MovieList_User

| Name              | Type          |  Relations  |
| -------------     | ----------    |-------------|
| movielist_id      | bigint        | PRIMARY KEY |
| movielist_name    | VARCHAR(255)  |  |
| user_id           | bigint        | FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)     |

## MovieList_Movie

| Name         | Type          |  Relations  |
| -------------| ----------    |-------------|
| movielist_id | bigint        | FOREIGN KEY (`movielist_id`) REFERENCES `MovieList` (`movielist_id`) |
| movie_id     | bigint        | FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`movie_id`) |


## User

| Name                  | Type            |  Relations  |
| -------------         | ----------      |-------------|
| user_id               | bigint          | PRIMARY KEY |
| user_name             | VARCHAR(255)    |             |
| user_email            | VARCHAR(255)    |             |
| user_password         | VARCHAR(255)    |             |


# Mobile App
The Front End side of this app you can find [here](https://github.com/Elokuva-Projekti-2023/MobileFilmProject)
