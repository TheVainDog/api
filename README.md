# API EMPLOYEES - Lean Solution Group 

This API allows to handle operation such as create, read, update, delete (CRUD) over Employee Table using: <br/>
 * **Java 8** <br/>
 * **Spring boot v2.4.8** <br/>
 * **JPA** <br/>
 * **H2 Data base in memory**

# Runnning API:
 
 1. Clone Repository: <br/>
      > git clone https://github.com/TheVainDog/api.git <br/>
 2. Navigate to api folder <br/>
      > cd api <br/>
 3. Run API <br/>
      > mvn spring-boot:run
 4. By Default API runs in port 8080, so Try the API
      > http://localhost:8080/employee/findall

 # Runnning API specifying a PORT:
  
  1. Clone Repository: <br/>
      > git clone https://github.com/TheVainDog/api.git <br/>
  2. Navigate to api folder <br/>
      > cd api <br/>
  3. Build API
      > mvn package
  4. Navigate to target folder
      > cd target
  5. Run the Jar file in a free port using parameter --server.port like this, example:
      > java -jar api-0.0.1-SNAPSHOT.jar --server.port=7788
  6. Try the API in the port you selected:
      > http://localhost:7788/employee/findall

# End points

* Create Employee(s)
    > /employee/save

* Update Employee
    > /employee/update/{id}

* Delete Employee
    > /employee/deletebyid/{id}

* List All Employee
    > /employee/findall

* Find Employee by ID
    > /employee/findbyid/{id}

* List All Position and his Employee(s) order desc by Salary
    > /position/findall

* Filter Position by Name (Optional) or Employee Name (Optional), if no parameters are given will return All Position and his Employees  
    > /position/findbypositionorname

# Postman collections file
 > api/src/main/resources/Lean Solution API.postman_collection.json 
