# FINAL PROJECT
# Automation Test Framework for Web and API Testing

## Project Description
Creating and developing an automation test framework that
integrates Selenium for Web UI testing and Rest Assured for API testing. This
framework is built using Java and organized with Cucumber to support Behavior Driven Development (BDD), facilitating the writing of test cases in Gherkin format.
The framework use to test e-commerce application (https://www.demoblaze.com)
and API endpoints (https://dummyapi.io/docs/user). Ensuring functionality and reliability of the application.

## Technologies Used
Java, Junit, Gradle, Rest Assured, Selenium, Cucumber, GitHub, GitHub Actions

## Built With
Automated testing projects involve several required libraries:
- cucumber framework
- selenium framework
- webdriver manager
- Junit
- assertion
- RestAssured

## Getting Started
These instructions will guide you on how to set up the project on your local machine for development and testing purposes.

### Prerequisites
Before getting started, ensure that you have the following software installed on your machine:

```
1. Java JDK: download and install the latest version of Java JDK from the official Oracle website (https://www.oracle.com/id/java/technologies/downloads/).
2. Gradle: Install Gradle by following the official Gradle installation guide (https://gradle.org/install/), but in this case, we are using 'gradlew'.

```

### Installing
To set up the development environment, follow these steps:

1. Clone this repository to your local machine using Git or download the ZIP file and extract it.
2. Open the project in your preferred Java IDE (e.g., IntelliJ or Eclipse).
3. Build the project and download dependencies using Gradle by running the following command in the terminal:

```
./gradlew build

```

## Running the tests
To execute the automated tests for API only, run the following Gradle task:

```
./gradlew apiTest

```

To execute the automated tests for web only, run the following Gradle task:

```
./gradlew webTest

```

These commands will run the Cucumber tests with the specified configurations and generate HTML test reports in the "reports" directory.
