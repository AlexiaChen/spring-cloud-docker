## Actuator Wiki

Spring Boot Actuator provide the feature of monitor status of the whole app.

Status's Data of app returned the form of json from REST API.

The form of REST API as follows:
http://\[ip\]:\[port\]/\[endpoint\]

The type of endpoint as follows:
- autoconfig => Display auto config info
- beans => Display all of beans of the whole app
- configprops => Display props list of all of @ConfigurationProperties
- dump => Display snapshot of thread working
- env => Display env variable of app
- health => Display health status of app
- info => Display info of app, need to custome info data field
- mappings => Display all of url path
- metrics => Display Metircs info of app
- shutdown => Shutdown app. need to enable from application.properties 
- trace => Display traces of http requests
