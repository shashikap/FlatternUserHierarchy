# Getting Started

### How to run the application
For further reference, please consider the following sections:

* Build the application and run using mvn spring-boot:run
* [Run the H2 Console](http://localhost:8080/h2-console)
   * Select the db as JDBC url as -jdbc:h2:mem:testdb
   * And add username password as per given in the application.yml 
   * Open and copy the the script inside the resources\sampledata\data.sql to insert the data, run it in the H2 console 
* [Run the swagger UI](http://localhost:8080/swagger-ui.html)

### About the Implementation
Created three Entity classes, two classes for to use existing hierarchy(user and teamhierarchy) and other
useraccess is to store the access level for each user.

Entity relationship added to the teamhierarchy table where i can get the sub user and manager relation ship

Created POST /addUserAccess/{empId} api to add user access for the given user

Create POST /addAllUserAccess api to add all users accesses in the organization

Note : Please note this,LYB49MKK_dev is company gitlab user name Which took from my .gitConfig in local [user] name = LYB49MKK_dev
