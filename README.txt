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




war 배포

프로젝트명Application.java/ SpringBootServletInitializer 상속 받고 configure 함수 override

package com.example.jerseyDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JerseyDemoApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(JerseyDemoApplication.class, args);
	}

	// war파일로 배포를 하기 위해 SpringBootServletInitializer를 상속받고, configure함수를 override했음
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JerseyDemoApplication.class);
	}

}

pom.xml 열어서 소스 추가

<!-- marked the embedded servlet container as provided --> 
<dependency> 
  <groupId>org.springframework.boot</groupId> 
  <artifactId>spring-boot-starter-tomcat</artifactId> 
  <scope>provided</scope> 
</dependency>

pom.xml version 아래에서 packaging 태그 추가
<packaging>war</packaging>

프로젝트 우클릭 / Run as /Maven build
Goals : package / Run
빌드 성공하면 경로 확인하고 target 폴더 war 생성 확인




tomcat docker war 배포
docker pull tomcat8
docker run -it -v /home/ehdru:/usr/local/tomcat/webapps -p 8080:8080 tomcat:latest /bin/bash
./usr/local/tomcat/bin/start.sh
/usr/local/tomcat/webapps 안의 war 파일이 자동으로 압축 풀렸는가 확인

GET 테스트
localhost:8080/jerseyDemo-0.0.1-SNAPSHOT/users
