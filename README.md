# Kata Bank Account Solution

A REST API Springboot App to perform basic bank account operations (deposit, withdraw and history) developed with a TDD approach.

This Springboot App was created from https://start.spring.io/ with Springboot version 2.7.4 and Java 17. 

During the App development, I used [SDKMAN](https://sdkman.io/install) with the following versions:
- java: 17.0.4.1-zulu
- maven: 3.6.3

The tests were created using Cucumber and JUnit 4.

The data are persisted as far as the application is running (Scope "application" in Operation Service).

## Requirements

Before installing and running the app, I suggest using the Java environment here below: 
    
- Java 17
- Maven version 3.6.3 or greater

## Run the app

    mvn spring-boot:run

This command will install and build the required dependencies if needed.

## Run the tests

    mvn clean test

# How to use the REST API Bank account

The REST API to the example app is described below.

## Deposit operation 

### Request

`POST /deposit`

Example of usage:
    
    curl -i --header "Content-Type: application/json" \
        --request POST \
        --data '{"amount":"10.0"}' \
        http://localhost:8080/api/v1/deposit

### Response

    HTTP/1.1 200 
    Content-Type: application/json
    Content-Length: 57
    Date: Wed, 19 Oct 2022 10:57:42 GMT

    { "responseMessage": "Operation completed successfully" }


## Withdraw operation

### Request

`POST /withdraw`

    Example of usage:
    
    curl -i --header "Content-Type: application/json" \
        --request POST \
        --data '{"amount":"10.0"}' \
        http://localhost:8080/api/v1/withdraw

### Response

    HTTP/1.1 200 
    Content-Type: application/json
    Content-Length: 57
    Date: Wed, 19 Oct 2022 11:02:16 GMT

    { "responseMessage": "Operation completed successfully" }

## Get history of operations with balance

### Request

`GET /history`

    curl -i --header "Content-Type: application/json" \
        http://localhost:8080/api/v1/history

### Response

    HTTP/1.1 200 
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Wed, 19 Oct 2022 11:03:25 GMT

    [
        {
            "amount": 10,
            "date": "2022-10-19T12:57:42.692085573",
            "balance": 10,
            "operationType": "DEPOSIT"
        },
        {
            "amount": 10,
            "date": "2022-10-19T13:02:16.563298747",
            "balance": 0,
            "operationType": "WITHDRAW"
        }
    ]

## Reset history of operations and balance 

### Request

`GET /reset`

    curl -i --header "Content-Type: application/json" \
        http://localhost:8080/api/v1/reset

### Response

    HTTP/1.1 200 
    Content-Type: application/json
    Content-Length: 57
    Date: Wed, 19 Oct 2022 11:02:16 GMT

    { "responseMessage": "Operation completed successfully" }
