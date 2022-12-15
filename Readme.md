# Rest-API with MongoDB and Kotlin

Sample project for an Rest-API to perform CRUD-Operations on a MongoDB, written in **Kotlin**.

## Pokedex
This App allows you to enter Pokemons you caught into a "Pokedex", which is our MongoDB.  
This will automatically generate a ***caughtDatum*** for the entry.


### Setup of the Database
I used **Docker** to setup an MongoDB-Container on my local Dev-Environment.  
You can do so by ```docker run -d --name some_mongo -p 27017:27017 -v mymongodata:/data/db mongo```.  

### Instructions for running
Run ```./gradlew bootRun``` in root of the project to run the SpringBoot App.  
Integrate with the Application via SwaggerUI available at ```http://localhost:8080/swagger-ui/```  
-OR-  
Send HTTP-Requests with Tools like **Postman**.
