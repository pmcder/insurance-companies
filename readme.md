### About

This project is the back end for my insurance company lookup tool. 
To view the tool on my personal website [click here](http://pmcderm.io)
and navigate to Insurance Company Lookup. 
Although the database is simple, I used this application to deepen my knowledge of Spring,
Spring Security, and JWT. 

### Building

you will need to add values 
for the following in application.properties 
security.jwt.token.expiration
security.jwt.token.secret-key
or use -Dskiptests and put them in with a command line switch

cd into ins-api

mvn clean package 

### Running

to use the database url in application.properties you can run with: 

java -jar target/ins-api-0.0.1-SNAPSHOT.jar 

or you can set your own database path with:

java -jar target/ins-api-0.0.1-SNAPSHOT.jar --spring.datasource.url="path to your database"


