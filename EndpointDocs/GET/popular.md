# Fetching popular movies

**URL:** `/api/tmdb/popular`

**Method:** `GET`

## *Successful response*

Content example (first three popular movies):

```json
[
    {
        "movieLists": [],
        "id": 968051,
        "title": "The Nun II",
        "overview": "In 1956 France, a priest is violently murdered, and Sister Irene begins to investigate. She once again comes face-to-face with a powerful evil.",
        "genre_ids": [
            "27",
            "9648",
            "53"
        ]
    },
    {
        "movieLists": [],
        "id": 926393,
        "title": "The Equalizer 3",
        "overview": "Robert McCall finds himself at home in Southern Italy but he discovers his friends are under the control of local crime bosses. As events turn deadly, McCall knows what he has to do: become his friends' protector by taking on the mafia.",
        "genre_ids": [
            "28",
            "53",
            "80"
        ]
    },
    {
        "movieLists": [],
        "id": 678512,
        "title": "Sound of Freedom",
        "overview": "The story of Tim Ballard, a former US government agent, who quits his job in order to devote his life to rescuing children from global sex traffickers.",
        "genre_ids": [
            "28",
            "18"
        ]
    }
```