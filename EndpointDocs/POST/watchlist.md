# Adding a movie to watchlist

**URL:** `/movielists/{movielistId}/add-movie-to-about-to-watch/{movieId}`

**Method:** `POST`

## *Successful response*

Content example:

```json
{
    "aboutToWatchListId": 1,
    "movies": [
        {
            "id": 695721,
            "title": "The Hunger Games: The Ballad of Songbirds & Snakes",
            "overview": "64 years before he becomes the tyrannical president of Panem, Coriolanus Snow sees a chance for a change in fortunes when he mentors Lucy Gray Baird, the female tribute from District 12.",
            "genre_ids": null,
            "poster_path": "/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg",
            "original_title": "The Hunger Games: The Ballad of Songbirds & Snakes",
            "release_date": "2023-11-15",
            "vote_average": 7.293,
            "vote_count": 466
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