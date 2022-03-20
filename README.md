# Getting Started

## Maven

### Compile Code
* ./mvnw clean compile -e

### Test Code
* ./mvnw clean test -e

### Jar Code
* ./mvnw clean package -e

### Run Jar
* Local:      ./mvnw spring-boot:run 
* Background: nohup bash mvnw spring-boot:run &

### Testing Application
* curl -X GET 'http://localhost:8080/rest/msdxc/dxc?sueldo=1500000&ahorro=12000000'

