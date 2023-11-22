# Fetching all users

**URL:** `/allusers`

**Method:** `GET`

## *Successful response*

Content example:

```json
[
    {
        "userId": 1,
        "firebaseUid": "3mn3rJALP0dI2REohnrozJ7rV5C2",
        "userName": "Tapio",
        "user_email": "tapsukka@mail.com",
        "favoritesList": {
            "movies": [],
            "movielist_id": 1
        },
        "onWatchList": {
            "onWatchListId": 1,
            "movies": []
        },
        "aboutToWatchList": {
            "aboutToWatchListId": 1,
            "movies": []
        }
    },
    {
        "userId": 2,
        "firebaseUid": "9MFC5uo33PN2qHEVBvivq3cOJMq1",
        "userName": "Tapio",
        "user_email": "tapsukka2@mail.com",
        "favoritesList": {
            "movies": [],
            "movielist_id": 2
        },
        "onWatchList": {
            "onWatchListId": 2,
            "movies": []
        },
        "aboutToWatchList": {
            "aboutToWatchListId": 2,
            "movies": []
        }
    }
]
```