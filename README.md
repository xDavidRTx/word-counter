# Windowed word counter

This small application reads the lines output by the blackbox.jar. This blackbox binary will print out JSON lines with attributes “event_type”, “data”, and “timestamp” or some random "trash".


To run the application we only need to have the blackbox.jar on the root of the directory and use: 

```
sbt run
```

The application exposes one end-point with the current word count: 

http://localhost:8000/current

The output will look somethin like this: 

```json
{
    "event_types": [
        [
            "bar",
            [
                {
                    "word": "ipsum",
                    "count": 4
                },
                {
                    "word": "lorem",
                    "count": 7
                },
                {
                    "word": "dolor",
                    "count": 8
                },
                {
                    "word": "sit",
                    "count": 11
                },
                {
                    "word": "amet",
                    "count": 10
                }
            ]
        ],
        [
            "baz",
            [
                {
                    "word": "lorem",
                    "count": 8
                },
                {
                    "word": "ipsum",
                    "count": 13
                },
                {
                    "word": "amet",
                    "count": 11
                },
                {
                    "word": "sit",
                    "count": 12
                },
                {
                    "word": "dolor",
                    "count": 8
                }
            ]
        ],
        [
            "foo",
            [
                {
                    "word": "amet",
                    "count": 9
                },
                {
                    "word": "sit",
                    "count": 14
                },
                {
                    "word": "lorem",
                    "count": 7
                },
                {
                    "word": "ipsum",
                    "count": 9
                },
                {
                    "word": "dolor",
                    "count": 10
                }
            ]
        ]
    ]
}
```
