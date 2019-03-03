## Eureka Wiki

- Run eureka-server project

- Run Movie and User Service

- Access http://localhost:8761/ to check all of services registered into eureka server


## Eureka HA
two nodes Arch:

- Change hosts (/etc/hosts) 127.0.0.1 peer1 peer2

- Run peer1 and peer2 nodes 

- Run Peer1:
   
   java -jar  [eureka-server].jar --spring.profiles.active=peer1
   
- Run Peer2:
   
   java -jar  [eureka-server].jar --spring.profiles.active=peer2
   
   
- Acccess http://peer1:8761 or http://peer2:8762, you will find the other replica node