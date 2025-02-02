
# Automation Project

## Overview
This repository contains an automation project structured into various modules and test suites. It primarily focuses on automating testing for web applications, including both web API and user interface testing.

## Structure
- `modules/`: This directory holds all the technical modules.
    - `general/`: Contains common libraries used across the project.
    - `microservices/`: Stores modules that interact with REST endpoints, using DTO models located in `models/`.
- `webapi-testng/`: This directory contains test cases for testing the web APIs.
- `webui-testng/`: This directory is dedicated to user interface testing with testng.
- `webui-testng-cucumber/`: This directory is dedicated to user interface testing with cucumber.

## Dependencies
The project uses several dependencies managed through Maven. Key dependencies include:

### Internal Dependencies

- `org.dmukhin:test-automation-object-mapper`: A utility for object mapping in tests.
- `org.dmukhin:test-automation-config`: Configuration management utility for tests.
- `org.dmukhin:test-automation-assertions`: A set of assertions for testing.
- `org.dmukhin:test-automation-utils`: General utilities for testing.
- `org.dmukhin:test-automation-general-microservice`: Tools specific for testing microservices.
- `org.dmukhin:test-automation-placeholder-microservice`: Placeholder tools for microservice
  testing.

### AspectJ Dependencies

1. **aspectjweaver**
    - **Description**: Provides support for aspect-oriented programming, such as interceptors.
    - **Group ID**: org.aspectj
    - **Version**: ${org.aspectj.version}

2. **aspectjrt**
    - **Description**: AspectJ runtime, required for executing aspect-oriented features.
    - **Group ID**: org.aspectj
    - **Version**: ${org.aspectj.version}

### Allure Framework Dependencies

1. **allure-bom**
    - **Description**: Allure Framework's Bill of Materials, manages versions of Allure
      dependencies.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

2. **allure-testng**
    - **Description**: Allure integration with TestNG for generating test reports.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

3. **allure-rest-assured**
    - **Description**: Allure integration with REST Assured for API testing reports.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

4. **allure-cucumber7-jvm**
    - **Description**: Allure integration with Cucumber for generating test reports.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

5. **allure-junit-platform**
    - **Description**: Allure integration with JUnit Platform for generating test reports.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

### Google Guava Library

1. **guava**
    - **Description**: Google Guava library provides collection types, utilities, and more.
    - **Group ID**: com.google.guava
    - **Version**: ${guava.version}

### Selenide for Web Testing

1. **selenide**
    - **Description**: Selenide simplifies Selenium-based web UI testing.
    - **Group ID**: com.codeborne
    - **Version**: ${selenide.version}

2. **allure-selenide**
    - **Description**: Integration of Allure with Selenide for enhanced testing reports.
    - **Group ID**: io.qameta.allure
    - **Version**: ${allure.version}

### Jackson for JSON Processing

1. **jackson-core**, **jackson-annotations**, **jackson-databind**
    - **Description**: Jackson's libraries provide JSON processing and data-binding functionality.
    - **Group ID**: com.fasterxml.jackson.core
    - **Version**: ${com.fasterxml.jackson.core.version}

### Log4j for Logging

1. **log4j-api**, **log4j-core**
    - **Description**: Log4j provides logging functionality.
    - **Group ID**: org.apache.logging.log4j
    - **Version**: ${org.apache.logging.log4j.version}

### REST Assured for API Testing

1. **rest-assured**
    - **Description**: REST Assured simplifies testing of RESTful APIs.
    - **Group ID**: io.rest-assured
    - **Version**: ${io.rest-assured.version}

### Apache Commons Libraries

1. **commons-lang3**
    - **Description**: Apache Commons Lang provides extra functionality for Java's lang API such as
      StringUtils.
    - **Group ID**: org.apache.commons
    - **Version**: ${commons-lang3.version}

2. **commons-io**
    - **Description**: Apache Commons IO is a library of utility methods for IO functionalities.
    - **Group ID**: commons-io
    - **Version**: ${commons-io.version}

### AssertJ for Fluent Assertions in Tests

1. **assertj-core**
    - **Description**: AssertJ library provides a fluent interface for writing assertions in tests.
    - **Group ID**: org.assertj
    - **Version**: ${assertj-core.version}

### Test Frameworks

1. **testng**
    - **Description**: TestNG is used as the testing framework, providing annotations and running
      capabilities.
    - **Group ID**: org.testng
    - **Version**: ${org.testng.version}

2. **junit-platform-suite**
    - **Description**: JUnit is used as the testing framework, providing annotations and running
      capabilities.
    - **Group ID**: org.junit.platform
    - **Version**: ${org.junit.platform.version}

3. **junit-jupiter-api**, **junit-jupiter-engine**
    - **Description**: JUnit Jupiter API and Engine for JUnit testing.
    - **Group ID**: org.junit.jupiter
    - **Version**: ${org.junit.jupiter.version}

### JavaFaker for Generating Fake Test Data

1. **javafaker**
    - **Description**: JavaFaker is used to generate fake data for tests.
    - **Group ID**: com.github.javafaker
    - **Version**: ${com.github.javafaker.version}

### Cucumber

1. **cucumber-java**, **cucumber-core**, **cucumber-junit-platform-engine**
    - **Description**: Cucumber libraries for behavior-driven development (BDD) testing.
    - **Group ID**: io.cucumber
    - **Version**: ${io.cucumber.version}

## Prerequisites
- Java Development Kit (JDK)
- Maven

## Installation
1. Clone the repository to your local machine.
2. Navigate to the root directory of the project.
3. Use Maven to install dependencies:
   ```shell
   mvn clean install
   ```

## Running Tests
- To run the web API tests, navigate to `webapi-testng/` and execute:
  ```shell
  mvn test
  ```
- To run the web UI tests, navigate to `webui-testng/` and execute:
  ```shell
  mvn test
  ```
- To run the web UI tests, navigate to `webui-testng-cucumber/` and execute:
  ```shell
  mvn test
  ```

# Allure Report Generation Module

## Overview
This module guides you through the process of generating Allure reports from test results stored in `target/allure-results`. Allure Framework provides a flexible and comprehensive reporting tool, ideal for visualizing test execution results.

## Prerequisites
- Java Runtime Environment (JRE) or Java Development Kit (JDK).
- Allure Commandline Tool (Allure CLI) installed. Visit [Allure Documentation](https://docs.qameta.io/allure/) for installation instructions.
- Test results present in the `target/allure-results` directory.

## Generating Allure Report
Follow these steps to generate an Allure report:

1. **Generate Test Results**:
   Ensure that your tests are executed and the results are stored in `target/allure-results`. This is typically done automatically when running tests using a framework that supports Allure integration.

2. **Install Allure CLI**:
   If not already installed, install the Allure Commandline Tool. Detailed installation instructions can be found in the [Allure Documentation](https://docs.qameta.io/allure/).

3. **Generate Report**:
   Navigate to your project's root directory in the terminal. Execute the following command:
   ```shell
   allure serve target/allure-results
   ```
   This command will process the results in `target/allure-results`, generate a report, and start a web server to display the report.

4. **View Report**:
   The Allure report will be automatically opened in your default web browser. You can also manually open the report URL displayed in the terminal.

## Notes
- The Allure report provides insights into the executed tests, including test status, duration, and other details.
- Customization: You can customize the report generation by modifying the Allure configuration file or using command-line parameters.

## Troubleshooting
If you encounter any issues while generating the Allure report, ensure that:
- The Allure CLI is correctly installed and available in your system's PATH.
- The `target/allure-results` directory contains the test results.
