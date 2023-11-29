# Fetching user's lists

**URL:** `/movielists/{userId}/movie-lists`

**Method:** `GET`

## *Successful response*

Content example:

```json
{
    "favoritesList": {
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
            }
        ],
        "movielist_id": 1
    },
    "aboutToWatchList": {
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
            }
        ]
    },
    "onWatchList": {
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
            }
        ]
    }
}
```