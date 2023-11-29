# Adding a movie to watched movies list

**URL:** `/movielists/{movielistId}/add-movie-to-watched/{movieId}`

**Method:** `POST`

## *Successful response*

Content example:

```json
{
    "onWatchListId": 1,
    "movies": [
        {
            "id": 670292,
            "title": "The Creator",
            "overview": "Amid a future war between the human race and the forces of artificial intelligence, a hardened ex-special forces agent grieving the disappearance of his wife, is recruited to hunt down and kill the Creator, the elusive architect of advanced AI who has developed a mysterious weapon with the power to end the war—and mankind itself.",
            "genre_ids": null,
            "poster_path": "/vBZ0qvaRxqEhZwl6LWmruJqWE8Z.jpg",
            "original_title": "The Creator",
            "release_date": "2023-09-27",
            "vote_average": 7.148,
            "vote_count": 1200
        },
        {
            "id": 753342,
            "title": "Napoleon",
            "overview": "An epic that details the checkered rise and fall of French Emperor Napoleon Bonaparte and his relentless journey to power through the prism of his addictive, volatile relationship with his wife, Josephine.",
            "genre_ids": null,
            "poster_path": "/jE5o7y9K6pZtWNNMEw3IdpHuncR.jpg",
            "original_title": "Napoleon",
            "release_date": "2023-11-22",
            "vote_average": 6.484,
            "vote_count": 366
        }
    ]
}
```