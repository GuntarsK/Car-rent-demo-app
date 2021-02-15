## Car Rental app

This is a back-end part of a demo app that allows to perform CRUD operations through a simple web intefrace.

Front-end code for this app is placed in a separate repository: https://github.com/GuntarsK/Car-rent-frontend.git



## Getting started

### Clone `Car-Rent-Demo-App`

Clone the `Car-Rent-Demo-App` repository using git:

```
git clone https://github.com/GuntarsK/Car-Rent-Demo-App.git
```



### Run the Application

After starting the application, it's functions can be tested in a following ways:

* Access H2 in-memory database console: http://localhost:8080/h2-console/login.do

  JDBC URL: `jdbc:h2:mem:testdb`
  
  User Name: `sa`

  Password: `password`
  

* Swagger UI to test REST API requests: http://localhost:8080/swagger-ui.html

* Clone and launch front-end part of the app. Project is located in a separate repository: https://github.com/GuntarsK/Car-rent-frontend.git 


### Functionality

  * Get Car/Customer/Booking records from DB
  
  * Create new Car/Customer/Booking record in DB
  
  * Update existing Car/Customer/Booking information
  
  * Delete Car/Customer/Booking
  
  * Search for a Car/Customer/Booking



