## Ribbon wiki

- Run eureka server with default
- run 2 or more instances of user service with different port
- run movie service with default


java -jar [eureka-server.jar]
java -jar [user-service.jar] --server.port=[8000 | 8001]
java -jar [movie-service.jar]


Access movie service user endpoint API: http://localhost:8002/user/[id]
you will find is two different user service providing service for movie service 
by loadbalancing

access http://localhost:8002/user-service-instance/info/log
you will find which user service instance is currently chosen.