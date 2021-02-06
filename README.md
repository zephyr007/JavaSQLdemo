# SpringBoot Jpa API 

## 1.Java CRUD API

```REST application of user management using Spring Boot and Spring Data. This application will perform basic CRUD(Create, Read , Update , Delete) operations on the User table.

1.API which will create a user in the user table.
url:http://localhost:8080/user
METHOD : POST
input:userName , firstName, lastName, mobileNumber , emailID, address1, address2
Validations : same email id, userName or phone number (user already exists)

2.API which will read data from the database.
url:http://localhost:8080/user?userId=<userID>
METHOD: GET
Result: ashutosh,rathor, 999999999, ashutosh.rathor@paytm.com

3.Update API
url:http://localhost:8080/user
requestParam: userID
METHOD:(PUT)
validation: user should exist

4.API which will delete data in the user table.
url:http://localhost:8080/user
requestParam: userID
validation: user should exist

Hint:
sample link https://www.journaldev.com/17034/spring-data-jpa```
```
Expectations:
=============

```Flow Diagram in UML
Schema Design
Workable Code with proper comment
```



## 2.Wallet Management

```1. Create Wallet: API which will create wallet for a user
url:http://localhost:8080/wallet
METHOD : POST
input: phone number
Validations : phone number should exist , only one wallet for a user.

2.API to transfer money from one wallet to another wallet (p2p).
url:http://localhost:8080/transaction
METHOD : POST
input:{payer_phone_number,payee_phone_number,amount}
Validations : payer and payee both should exist, payer should have sufficient balance.

3.Transaction Summary API
url:http://localhost:8080/transaction?userId=<userId>
METHOD: GET
Validations: userId should exists
Note : this api should return in a pagination way.

4.Transaction Status
url:http://localhost:8080/transaction?txnId=<txnID>
Method :GET
Validation: TransactionId should exists```

```
Expectations:
=============
```
Flow Diagram in UML
Schema Design
Code with proper comment
Junit Test cases
```