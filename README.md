# spring-cloud-docker
Learning Spring Cloud &amp; Docker

## Run Processes without eureka server

- first. Run User Service. 
cd user-service
mvn compile
mvn package
java -jar [user-service].jar

- second. Run Movie Service
cd movie-service
mvn compile
mvn package
java -jar [movie-service].jar

- third. Access http://localhost:8001/user/[id] (1-5)
returned json data from Movie Service.
Actually, the data source is from User Service. Movie Service just fetch data from User
Service.

