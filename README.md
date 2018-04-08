# Prime Numbers Rest API

### Requirements:
Write a RESTful service that calculates and returns all the prime numbers up to an including a number provided.

Example
The REST call should look like  http://your.host.com/primes/10  and should return JSON content:
{
  “Initial”:  “10
  “Priimes”: [2,3,5,7]
}

### Software Requirements
- The project must be written in Java 8.
- The project must use Maven OR Gradle to build, test and run.
- The project must have unit and integration tests.
- The project must run, in that the service should be hosted in a container e.g. Tomcat, Jetty, Spring Boot etc.
- You may use any frameworks or libraries for support e.g. Spring MVC, Apache CXF, Jackson etc.
- The project must be accessible from Github.

#### Optional Extensions
- Consider supporting varying return content type such as XML based on requested media type.
- Consider ways to improve performance e.g. caching, threading
- Consider supporting multiple algorithms based on optional parameters
- Consider adding API documentation

## Solutions:

#### Software requirements...
- Java 8
- Maven

#### how to Buid App...
> mvn clean install
#### how to Run Test alone...
> mvn test
#### Application Run
> mvn spring-boot:run [-Dserver.port={port}]
Default port 8080
#### Rest API Details
URL : http://{host}/primes/{initials}[?mediaType={json|xml}]

Examples:
- http://localhost:8080/primes/10
- http://localhost:8080/primes/10?mediaType=json
- http://localhost:8080/primes/10mediaType=xml

- Http Method : GET
- Accept header: application/xml, application/json
- URL Params :  Optional Query Param: mediaType=json|xml
- Response Codes: Success (200 OK) and Bad Request (400)
