# SpringBoot Jpa API 

## Tutorials
``
JWT Spring Security:https://www.youtube.com/watch?v=X80nJ5T7YpE
``

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

2.API calls that returns All Users
url:http://localhost:8080/allUsers
Method: GET
Result: return list of all Users so far

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

```
1. Create Wallet: API which will create wallet for a user
url:http://localhost:8080/wallet
METHOD : POST
input: phone number
Validations : phone number should exist , only one wallet for a user.

1.1 Update Wallet Bal
url:http://localhost:8080/wallet
Method: PUT
Validation: Updates Wallet Balanace

1.2 Get All Wallet
url:http://localhost:8080/wallet
Method: GET
Validation: returns All Transactions

2.API to transfer money from one wallet to another wallet (p2p).
url:http://localhost:8080/transaction
METHOD : POST
input:{payer_phone_number,payee_phone_number,amount}
Validations : payer and payee both should exist, payer should have sufficient balance.

3.Transaction Summary API
url:http://localhost:8080/transactionBy?userId=<userId>
METHOD: GET
Validations: userId should exists
Note : this api should return in a pagination way.

4.Transaction Status
url:http://localhost:8080/transactionStatus?txnId=<txnID>
Method :GET
Validation: TransactionId should exists

5.AllTransaction
url:http://localhost:8080/transaction
Method: GET

6.Get All TransactionWithElasticSearch
url:http://localhost:8080/elastic/AllTrans
Method: GET 
Validataion: Returns all transactions

7.Publish Transaction with Kafka into ELastic
url:http://localhost:8080/elastic/Trans
Method: POST

8.Publish Trans on Kafka Msg Stream
url:http://localhost:8080/kafka/publish/Trans
Method: POST

9.Authorize User
url:http://localhost:8080/auth
Method: POST
Vaildation: return JWT Token

10.Add Auth User
url:http://localhost:8080/addAuth
Method: POST
Validation: returns New JWT token

11.Auth check
url:http://localhost:8080/hello
Method: GET
validation: check JWT tokena and return "hello World"

```
Expectations:
=============
```
Flow Diagram in UML
Schema Design
Code with proper comment
Junit Test cases
```
