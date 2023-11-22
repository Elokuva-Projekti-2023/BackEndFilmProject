# Fetching all favorite lists

**URL:** `/movie/{movieId}`

**Method:** `GET`

## *Successful response*

Content example:

```json
[
    {
        "movies": [
            {
                "id": 939335,
                "title": "Muzzle",
                "overview": "LAPD K-9 officer Jake Rosser has just witnessed the shocking murder of his dedicated partner by a mysterious assailant. As he investigates the shooter’s identity, he uncovers a vast conspiracy that has a chokehold on the city in this thrilling journey through the tangled streets of Los Angeles and the corrupt bureaucracy of the LAPD.",
                "genre_ids": null,
                "poster_path": "/qXChf7MFL36BgoLkiB3BzXiwW82.jpg",
                "original_title": "Muzzle",
                "release_date": "2023-09-29",
                "vote_average": 6.707,
                "vote_count": 121
            }
        ],
        "movielist_id": 1
    }
]
```