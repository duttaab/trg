# trg
                    **Project Name: Map Services** 
##### Project Description: 
*A RESTful WebService which accepts GSM MAP parameters (JSON format) as request and converts into corresponding ASN.1 encoded bytes. As proof of concept the following MAP messages are used.*
1. *MAP-ALERT-SERVICE-CENTRE*
2. *MAP-READY-FOR-SM*

##### Technology/Tools Used:
1. *Spring Boot (https://spring.io/guides/gs/spring-boot/)*
2. *Maven (https://maven.apache.org/)*
3. *Eclipse IDE (https://www.eclipse.org/)*
4. *Postman (https://www.postman.com/)*
5. *jss7 MAP & ASN library (https://github.com/RestComm/jss7)*

##### Design Principle
*Based on design principle separation of concerns (SoC) the MVC pattern is used to break up the application into:*
1. *API/Controller layer*
   - *Provides the endpoints for the REST requests and frames the response.*
2. *Service layer*
   - *MAP request validation and processing.*
3. *Data Model layer*
   - *Container for MAP parameters.*
   - *MAP Statistics*
4. *Data Access Object Pattern*
   - *Interfaces for in-memory storage of request statistics*
5. *Exception Handler*
   - *A global exception handler for API/MAP message processing.*
   
 ##### Endpoint URL 
 1.  *To generate encoded bytes for MAP-ALERT-SERVICE-CENTRE - 
    POST /localhost:8080/map/alertservice/v3*
 2.  *To generate encoded bytes for MAP-READY-FOR-SM - 
     POST /localhost:8080/map/readyforsm/v3*
 3.  *To get statistics - 
    GET /localhost:8080/map/stats/v3*

 ##### Sample Outputs
 *Project folder 'postman' contains screen shots of HTTP requests for both the MAP messages*
 
 ##### Setup & Installation
 1. Import the Maven project and run  mvn install
 2. Use either Postman/Curl command to test the end points 

 
