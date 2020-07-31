# API automation for Products API

This document explains required software, test structure and how to run tests.

## Prerequisites
Software that is required to make this repo work :) 
- Java 1.8
- Maven 

### Libraries used

#### rest-assured

- Test and validate API end points

#### TestNG

- Is used mainly as test runner, to maintain test structure using annotations

#### gson

- Java library to serialize and deserialize Java objects to JSON

#### hamcrest

- Used for assertions, matchers to verify results

## Test structure

__ProductAPI__ - Has extracted calls for Products API

__Product__ - To form a body for Products API from product.properties file

__PropertiesReader__ - Utility to read properties from various property files

__Resources__ - Contains property files

__env.properties__ - Environment details for the environment on which the tests need to be run

__product.properties__ - product details to create product body

__test.productTests__ - Contains tests check [Testcases](TESTCASES.md) for details

## Running Test

From terminal use `mvn clean test` to run all the tests
use `mvn -Dtest=testfilename test` to run a specific file

Find reports under target -> surefire-reports
