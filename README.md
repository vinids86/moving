## About

This is an example project that illustrates creating a RESTful API in Spring Boot with OAuth2.

## Runnning

```
mvn spring-boot:run
```

## Endpoints

```
#get token
curl -X POST --user 'moving-client:secret' -d 'grant_type=password&username=viniciusdsaraiva@gmail.com&password=123' http://localhost:8080/oauth/token

#create a user
curl -X POST -d '{"name":"Vinicius", "lastname":"Saraiva", "email":"viniciusdsaraiva2@gmail.com", "password":"123", "confirmPassword":"123"}' -H "Accept: application/json" -H "Authorization: Bearer ${TOKEN}" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/user

#update password
curl -X PATCH -d '{"newPassword":"321"}' -H "Accept: application/json" -H "Authorization: Bearer f4a9bd1d-0abb-4786-b6ae-371fabcbb629" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/user/1/password

#logout(desabilita o token)
curl -X DELETE -d '{"newPassword":"321"}' -H "Accept: application/json" -H "Authorization: Bearer f4a9bd1d-0abb-4786-b6ae-371fabcbb629" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/user/1/logout

#forgot password(reset token generate in 'select * from users;'
curl -X POST -d '{"email":"viniciusdsaraiva@gmail.com"}' -H "Accept: application/json" -H "Authorization: Bearer 86a50138-86f0-43d7-bd2f-ce20b14f8c37" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/user/1/password/forgot

#reset token
curl -X POST -d '{"resetToken":"${RESET_TOKEN}", "newPassword":"123"}' -H "Accept: application/json" -H "Authorization: Bearer ${TOKEN}" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/user/1/password/reset

#create imovel
curl -X POST -d '{"description":"teste", "imobiliariaId":1, "address":"Rua dos Pinheiros, 131", "type":"APARTAMENTO"}' -H "Accept: application/json" -H "Authorization: Bearer ${TOKEN}" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/imovel

#retrieve imovel
curl -H "Accept: application/json" -H "Authorization: Bearer 86a50138-86f0-43d7-bd2f-ce20b14f8c37" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/imovel/1

#list all imoveis
curl -H "Accept: application/json" -H "Authorization: Bearer 86a50138-86f0-43d7-bd2f-ce20b14f8c37" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/imovel

#update imovel
curl -X PUT -d '{"id":1, "imobiliariaId":"1", "description":"alterado", "address":"Rua dos Pinheiros, 132", "type":"CASA"}' -H "Accept: application/json" -H "Authorization: Bearer 86a50138-86f0-43d7-bd2f-ce20b14f8c37" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/imovel/1

#delete imovel
url -X DELETE -H "Accept: application/json" -H "Authorization: Bearer 86a50138-86f0-43d7-bd2f-ce20b14f8c37" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/imovel/1
```


## Lombok

É necessário instalar o plugin Lombok na IDE:
[eclipse](https://projectlombok.org/setup/eclipse)
[intellij](https://projectlombok.org/setup/intellij)

## LICENSE

The code is released under the Apache License 2.0. See LICENSE for details. :P