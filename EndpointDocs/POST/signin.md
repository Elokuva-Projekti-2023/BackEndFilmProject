# User sign in

**URL:** `/api/auth/signin`

**Method:** `POST`

## *Successful response*

Content example:

```json
{
    "userData": {
        "userId": 1,
        "firebaseUid": "firebase id here",
        "userName": "testman",
        "user_email": "testman3@mail.com",
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
    "sessionToken": "here is a session token"
}
```
