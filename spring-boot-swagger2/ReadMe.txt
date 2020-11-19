CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Requirements
 * Installation
 * Configuration
 * Troubleshooting

Introduction:

This Project contains a rest api which is capable of performing the basic CRUD operations on Trades.Operations include
Create Trade
Delete all trades
get all trades
get trades by user id
get trades between dates specified
get highest and lowest price for a particular symbol


 Requirements:
JD 11 is required for this project.


 Installation and Configuration

Create a Springboot maven project with the following dependencies
Springboot starter
Springboot WEB
Spring data jpa
Spring h2 database

Run as a simple sprinboot app


Troubleshooting:

Access H2 at http://localhost:9090/h2/login.do

Access Swagger at http://localhost:9090/swagger2-demo/swagger-ui.html#/

make sure the above context paths are different , otherwise only one of them will work



