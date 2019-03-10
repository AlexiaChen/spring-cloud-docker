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

## Eureka Server REST API
Eureka Server provides APIs that register your non-JVM micro-service into Eureka Server, 
Or discovery other micro-services


- register new app instance:   POST /eureka/apps/[app-id]
- delete registered app instance: DELETE /eureka/apps/[app-id]/[instance-id]
- send app instance heartbeat: PUT /eureka/apps/[app-id]/[instance-id]
- query for all instances: GET /eureka/apps
- query for all app id instance: GET /eureka/apps/[app-id]

and so on.

## Eureka Server self protection
use eureka.server.enable-selft-preservation=false disable self protection feature.

## Eureka Client select IP register to eureka server
https://blog.csdn.net/u011164906/article/details/84504135 

