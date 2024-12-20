# myRetail RESTful Servie 

Internal REST Service to aggregate product data from multiple sources and return it as JSON to the caller.


Prerequesits:
   - Java 17 or later ([Installation Instructions](https://www.oracle.com/java/technologies/downloads/#java21))
   - Gradle 7.5+ ([Installation Instructions](https://gradle.org/install/))
   - MongoDB 8.0+ ([Installation Instructions](https://www.mongodb.com/docs/manual/installation))

Compile/Tested with:
- Java 21
- Gradle 8.11.1
- MongoDB 8.0.4


# Running Endpoint
Before running, MongoDB must be installed locally. Test data will be create and inserted on start up.

Run gradlew via terminal to start the application: 
`./gradlew bootRun`

Hit endpoint on localHost: 
`http://localhost:8080/myretailservice/product/13860428`


## Tests
Run tests: `./gradlew test`

# References

- [Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/reference/index.html)
- [Spring Mongo Data Repositories](https://docs.spring.io/spring-data/mongodb/reference/mongodb/repositories/repositories.html)



