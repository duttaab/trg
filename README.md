                                        **Project Name: Map Services** 
##### Project Description: 
*A RESTful WebService which accepts GSM MAP parameters (JSON format) as request and converts into corresponding ASN.1 encoded bytes. 
As proof of concept the following MAP messages are used.*
1. *MAP-ALERT-SERVICE-CENTRE*
2. *MAP-READY-FOR-SM*

##### Technologys/Tools Used:
1. *Spring Boot (https://spring.io/guides/gs/spring-boot/)*
2. *Maven (https://maven.apache.org/)*
3. *Eclipse IDE (https://www.eclipse.org/)*
4. *Postman (https://www.postman.com/)*
5. *jss7 MAP & ASN library (https://github.com/RestComm/jss7)*

##### Design Principle
*Based on design principle separation of concerns (SoC) the MVC pattern is used to break up the application into:*
1. *API/Controller layer*
   - *Provides the endpoint for the REST requests and frames the response.*
2. *Service layer*
   - *MAP request validation and processing.*
3. *Data Model layer*
   - *Container for MAP parameters.*
3. *Exception Handler*
   - *A global execption handler for API/MAP message processing.*
   
