# Adding a movie to favorites list

**URL:** `/movielists/{movielistId}/add-movie-to-favorites/{movieId}`

**Method:** `POST`

## *Successful response*

Content example:

```json
{
    "movies": [
        {
            "id": 901362,
            "title": "Trolls Band Together",
            "overview": "When Branch’s brother, Floyd, is kidnapped for his musical talents by a pair of nefarious pop-star villains, Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.",
            "genre_ids": null,
            "poster_path": "/sEaLO9s7CIN3fjz8R3Qksum44en.jpg",
            "original_title": "Trolls Band Together",
            "release_date": "2023-10-12",
            "vote_average": 7.107,
            "vote_count": 205
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
    ],
    "movielist_id": 1
}
```