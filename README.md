# Vega Virtual Device Tests

Test framework automation using Java, Maven, and Appium for testing the Vega application in 'Vega Virtual Device'.

## Description
This project contains automated tests for the Vega Virtual Device, leveraging:
- **Java 17**
- **Maven** for build and dependency management
- **Appium** for automation
- **TestNG** for test execution
- **Log4j** for logging
- **Allure** for reporting

## Prerequisites

Ensure you have the following installed:
- **Java Development Kit (JDK) 17**
- **Maven 3.8+**
- **Appium 2.x**

## Installation

1. Clone the repository.
2. Navigate to the project directory:
   ```bash
   cd vega-virtual-device-tests
   ```
3. Install dependencies:
   ```bash
   mvn clean install -DskipTests
   ```

## Running Tests

To run the tests, use the following command:

```bash
mvn clean test
```

## Reporting

After running the tests, you can generate and view the Allure report:

```bash
mvn allure:serve
```
