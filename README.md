# JavaApi

## Api Rest (Springboot 2.7 -  Java 11)

### Steps to run

### Start mysql database in a docker container

1. In root folder execute `cd dockers/`
2. Execute `docker-compose up -d`

### Run app

3. Run app as an springboot app
 
* At Start it must create the table user because the spring-hibernate implementation.
* if not, you can execute the file `create.sql` at the root of project


### Get postman Collection 

If you want to test it There is a postman collection with the calls to the API here:

src/main/resources/PostmanCollection
