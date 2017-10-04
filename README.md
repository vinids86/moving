## About

This is an example project that illustrates creating a RESTful API in Spring Boot with OAuth2.

## Runnning

```
mvn spring-boot:run
```

## Get token

```
curl -X POST --user 'moving-client:secret' -d 'grant_type=password&username=viniciusdsaraiva@gmail.com&password=123' http://localhost:8080/oauth/token
```

## LICENSE

The code is released under the Apache License 2.0. See LICENSE for details. :P