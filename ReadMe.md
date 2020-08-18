# Spring Boot Maven Multi Module Project with MongoDB and PostgreSQL

## Requirements 

Java 1.8 or higher  
Apache Maven 3  
Lombok  
Docker environment  

## How to use

### Build
```
$ mvn install
```

### Create and start MongoDB container and PostgreSQL container
```
$ pushd docker
$ docker-compose up -d
$ popd
```
MongoDB runs on port 27018 without credentials, and PostgreSQL runs on 5433 port with postgres/postgres.
PostgreSQL databases and tables are automatically created.

### Start Spring Boot App
```
$ cd multi-module-batch/sample-db-access
$ mvn spring-boot:run
```
or  
```
$ cd multi-module-batch/sample-db-access
$ java -jar target/sample-db-access-0.0.1.jar
```

### Stop MongoDB and PostgreSQL
```
$ pushd docker
$ docker-compose down
$ popd
```
