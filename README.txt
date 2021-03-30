Spring Initializer
https://start.spring.io/

Project : Maven Project
Language : Java
Spring Boot : 2.4.4
Project Metadata
Group : com.example
Artifact : demo
Name : demo
Description : Demo project for Spring Boot
Package name : com.example.demo
Packaging : Jar
Java : 11

Generate CTRL + Enter

압축 풀기 / 이클립스 Project Explorer 우클릭 / import / existing maven projects / root directory browse로 압축해제한 폴더 담기 / finish


SpringBoot 코드 작성하고 Run As JerseyDemoApplication

port가 이미 사용중이라는 문제가 나오면 src/main/resource/application.properties에 추가(기본 포트는 8080)
server.port = 8082

Postman 또는 브라우처 창에 검색

Request all users
GET | localhost:8082/users

Request one user by userId
GET | localhost:8082/users/1

Create new user
POST | localhost:8082/users/
Headers | KEY : Content-Type, Value : applicaition/json
Body/raw
{
    "id": 4,
    "firstName": "Donggyeong",
    "lastName": "Roh",
    "setUri": "/user-management/3"
}

Update one user by userId
PUT | localhost:8082/users/
Headers | KEY : Content-Type, Value : applicaition/json
Body/raw
{
    "id": 5,
    "firstName": "NewFirstName",
    "lastName": "NewLastName",
    "setUri": "/user-management/5"
}

Delete one user by userId
DELETE | localhost:8082/users/4