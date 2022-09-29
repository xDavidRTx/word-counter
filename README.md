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
  "event_types": {
    "bar": {
      "word_count": {
        "dolor": 2,
        "lorem": 5,
        "amet": 5,
        "ipsum": 6,
        "sit": 7
      }
    },
    "foo": {
      "word_count": {
        "dolor": 3,
        "lorem": 5,
        "amet": 6,
        "ipsum": 6,
        "sit": 6
      }
    },
    "baz": {
      "word_count": {
        "dolor": 5,
        "amet": 7,
        "ipsum": 5,
        "sit": 1
      }
    }
  }
}
```
