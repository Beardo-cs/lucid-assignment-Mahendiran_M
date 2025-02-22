# Prerequisities
JDK 11

Docker

Postman (Functional Validation)

intelliJ (Automation Scripting)

# How bring the mockservice up
cd mockserver  
docker compose up  
the mocke server will start at port 1080

# How bring the service up
./mvnw clean install -DskipTests  
java -jar target/simple-springboot-app-0.0.1-SNAPSHOT.jar  
The server will start at port 9001

# How to run the tests
./mvnw test  

# Assignment documentation
https://docs.google.com/document/d/1CbvJ-TWCC0DcDDEoqTzxQQti-NAuzGaD7mbVG1TrlkA/edit?tab=t.0#heading=h.gxdppzf8y50k

# Functional test cases
https://docs.google.com/spreadsheets/d/16iGFq2QKm1M-DEnXn7m9VlbOcFg9FPEeDwAyeIRNtLo/edit?gid=468590208#gid=468590208

# E2E Automation test cases
https://docs.google.com/spreadsheets/d/16iGFq2QKm1M-DEnXn7m9VlbOcFg9FPEeDwAyeIRNtLo/edit?gid=2108871606#gid=2108871606



