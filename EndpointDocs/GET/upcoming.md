# Fetching upcoming movies

**URL:** `/api/tmdb/upcoming`

**Method:** `GET`

## *Successful response*

Content example (first three upcoming movies):

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
        "id": 1008042,
        "title": "Talk to Me",
        "overview": "When a group of friends discover how to conjure spirits using an embalmed hand, they become hooked on the new thrill, until one of them goes too far and unleashes terrifying supernatural forces.",
        "genre_ids": [
            "27",
            "53"
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