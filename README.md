
# Tenpo Challenge - Juan Carlos Acosta

## Content

- [Requirements](#requerimientos)
    - [Used_Technologies](#used-technologies)
    - [Coments](#comments)
- [Setup](#setup)
    - [Instructions](#intructions)
    - [Usage](#usage)
    - [API URL](#api)
    - [Services](#services)
        - [Swagger](#swagger)
- [Test](#test)
    - [UnitTest](#unittest)
    - [Coverage](#cobertura)

### Used Technologies
- [JDK 17](https://www.oracle.com/index.html)
- [Spring Boot](https://projects.spring.io/spring-boot/)
- [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Docker](https://www.docker.com/)
- [Postgre SQL](https://www.postgresql.org/)
- [Log4J2](http://www.slf4j.org/)
- [jUnit](http://junit.org/junit5/)
- [Mockito](http://site.mockito.org/)
- [Maven](https://maven.apache.org/)
- [Jacoco](https://www.jacoco.org/jacoco/trunk/index.html)
- [Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

### Requirements:

It is necessary to design an API where the loans that companies make to their employees can be managed.

A company is made up of:
1. A "NIT" which is the tax identification number.
2. A verification digit, which is used to validate the NIT.
3. A name.
4. An address.
   
An Employee is made up of:
1. Employee ID.
2. Full name.
3. Salary.
4. Hiring date.
5. Birth date.
    
A Loan is made up of:
1. The value of the loan.
2. The number of installments agreed for the loan.
3. Loan Start Date.
- A company can have many employees.
- An employee can only work in one company.
- An employee may have one or more active loans.
- The verification digit is automatically generated and the procedure to calculate it is as follows: let's use the following NIT:
  
  1 2 3 4 5 6 7 8 9

  8  0  2  0  1  8  2  6  2

1. Add the digits that are in the odd positions; that is, in positions number 1, 3, 5, 7 and so on. In this case they are: 8+2+1+2+2 = 15
2. The result of the addition 15 is multiplied by 3 = 45
3. Add the digits that are in even positions: 0+0+8+6= 14
4. Now we must add the two results (45) + (14) = 59.
5. What number must be added to 59 to get a multiple of 10, that is, 60? The number is 1, 59 + 1 = 60.
6. So, we have that 1 is the number that is used to calculate the VD.
   
This API should be able to:
- Create, read, update and delete companies, employees, and loans.

### Commentes
Se desarrolla la api en dos modulos principales, los cuales se componen de:
1. Api Rest Principal (CRUDs)
2. Almacenamiento en BD (Postgres)

Se tienen 3 paths
- '/company'
- '/empoloyee'
- '/load'

Cada uno es responsable de manejar el CRUD de cada entidad con sus respectivas validaciones

Ejemplo:
```
curl --location --request POST 'http://localhost:8080/company' 
"header" []
"body": {
         "name": "Asp Solution",
        "nit": "800256314",
        "dvNit": 1,
        "address": "Cll 15 25 25"
    }
```

### Setup
#### Instrucciones
En primer lugar hay q tener instalado `docker-compose`. Se instala de la siguiente manera:

Para mac
```
brew install docker-compose
```
Para linux
```
apt install docker-compose
```

Abrir el Proyecto Adjunto aspSolutions y ejecutar el siguiente comando, desde la raiz del projecto
```
docker-compose build
docker-compose up
```

o tambien se puede ejecutar este comando
```
docker-compose up --bulid
```

Comprobar que los containers esten levantados
```
docker ps
```
Deberían haber tres, la api, PgAdmin y la base de datos Postgres.
### API Url
URL Local: http://localhost:8080/

### Endpoints
POST http://localhost:8080/company {JSON}
PUT http://localhost:8080/company {JSON}
GET http://localhost:8080/company
GET http://localhost:8080/company {JSON}
DELETE http://localhost:8080/company {JSON}

POST http://localhost:8080/load {JSON}
PUT http://localhost:8080/load {JSON}
GET http://localhost:8080/employee
GET http://localhost:8080/employee {JSON}
DELETE http://localhost:8080/employee {JSON}

POST http://localhost:8080/load {JSON}
PUT http://localhost:8080/load {JSON}
GET http://localhost:8080/load
GET http://localhost:8080/load {JSON}
DELETE http://localhost:8080/load {JSON}

### Services
#### Swagger
./TenpoCollection.postman_collection.json
http://localhost:8080/swagger-ui/

### Test
#### UnitTest

Para la ejecucion de los test unitarios utilice jUnit.

#### Coverage

Para la cobertura de código se utilizó la herramienta Codecov, muestra un 80% de coverage.
