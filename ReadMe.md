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
$ cd docker
$ docker-compose up -d
```
MongoDB runs on port 27018 without credentials, and PostgreSQL runs on 5433 port with postgres/postgres.
PostgreSQL databases and tables are automatically created.

### Stop MongoDB and PostgreSQL
```
$ cd docker
$ docker-compose down
```
