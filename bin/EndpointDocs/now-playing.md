# Fetching now playing movies

**URL:** `/now-playing`

**Method:** `GET`

## *Successful response*

Content example (first three now playing movies):

```json
{
    "dates": {
        "maximum": "2023-09-25",
        "minimum": "2023-08-08"
    },
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/H6j5smdpRqP9a8UnhWp6zfl0SC.jpg",
            "genre_ids": [
                28,
                878,
                12
            ],
            "id": 565770,
            "original_language": "en",
            "original_title": "Blue Beetle",
            "overview": "Recent college grad Jaime Reyes returns home full of aspirations for his future, only to find that home is not quite as he left it. As he searches to find his purpose in the world, fate intervenes when Jaime unexpectedly finds himself in possession of an ancient relic of alien biotechnology: the Scarab.",
            "popularity": 3538.632,
            "poster_path": "/mXLOHHc1Zeuwsl4xYKjKh2280oL.jpg",
            "release_date": "2023-08-16",
            "title": "Blue Beetle",
            "video": false,
            "vote_average": 7.1,
            "vote_count": 863
        },
        {
            "adult": false,
            "backdrop_path": "/iiXliCeykkzmJ0Eg9RYJ7F2CWSz.jpg",
            "genre_ids": [
                28,
                9648,
                53,
                80
            ],
            "id": 762430,
            "original_language": "en",
            "original_title": "Retribution",
            "overview": "When a mysterious caller puts a bomb under his car seat, Matt Turner begins a high-speed chase across the city to complete a specific series of tasks. With his kids trapped in the back seat and a bomb that will explode if they get out of the car, a normal commute becomes a twisted game of life or death as Matt follows the stranger's increasingly dangerous instructions in a race against time to save his family.",
            "popularity": 1847.972,
            "poster_path": "/oUmmY7QWWn7OhKlcPOnirHJpP1F.jpg",
            "release_date": "2023-08-23",
            "title": "Retribution",
            "video": false,
            "vote_average": 6.8,
            "vote_count": 218
        },
        {
            "adult": false,
            "backdrop_path": "/8pjWz2lt29KyVGoq1mXYu6Br7dE.jpg",
            "genre_ids": [
                28,
                878,
                27
            ],
            "id": 615656,
            "original_language": "en",
            "original_title": "Meg 2: The Trench",
            "overview": "An exploratory dive into the deepest depths of the ocean of a daring research team spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival.",
            "popularity": 1557.198,
            "poster_path": "/4m1Au3YkjqsxF8iwQy0fPYSxE0h.jpg",
            "release_date": "2023-08-02",
            "title": "Meg 2: The Trench",
            "video": false,
            "vote_average": 7,
            "vote_count": 1942
        },
 ...
```