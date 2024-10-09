# TODOIST TEST PROJECT

This project tests the CRUD  methods for the Project API of the [Todoist](https://todoist.com) application, using REST Assured, Maven, Java, Junit, AssertJ.

## How to run the tests

1. Register for an account on [Todoist](https://todoist.com).
2. To run the tests, you need your own API Bearer Token.
   To obtain the token, follow these steps:

- Navigate to Settings
- Select Integration
- Go to the Developers tab
- Copy Token API
3. Run the tests using the command below:

```bash
mvn clean test -DTOKEN="YOUR_BEARER_API_TOKEN"
//example
mvn clean test -DTOKEN="Bearer 345jjkn2kj4l2lkj234"
```



