# Automation Framework

A comprehensive Selenium WebDriver automation framework with Cucumber BDD support and Allure reporting capabilities.

## Overview

This project provides a robust test automation framework built with Selenium WebDriver, Cucumber, and TestNG. It includes integrated Allure reporting for detailed test execution insights.

## Technologies Used

- **Java 24** - Programming language
- **Selenium WebDriver 4.35.0** - Browser automation
- **Cucumber 7.30.0** - Behavior-Driven Development (BDD) framework
- **TestNG 7.11.0** - Testing framework
- **Allure 2.30.0** - Test reporting tool
- **Maven** - Build and dependency management
- **Jackson Databind 2.19.2** - JSON processing
- **Spring Core 7.0.0-RC2** - Dependency injection

## Project Structure

```
Automation/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       ├── java/
│       │   ├── base/          # Base classes for test setup
│       │   ├── cucumber/      # Cucumber step definitions
│       │   └── scripts/       # Test scripts
│       └── resources/
│           ├── feature/       # Cucumber feature files
│           ├── testData/      # Test data files
│           ├── allure.properties
│           └── framework.properties
└── pom.xml
```

## Prerequisites

Before running the tests, ensure you have the following installed:

- Java Development Kit (JDK) 24 or higher
- Maven 3.6 or higher
- Web browser (Chrome, Firefox, etc.)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/EhabMekky/Automation.git
```

2. Navigate to the project directory:
```bash
cd Automation
```

3. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Execute all tests:
```bash
mvn test
```

### Run specific test suite:
```bash
mvn test -Dtest=TestClassName
```

### Run Cucumber tests:
```bash
mvn test -Dcucumber.filter.tags="@YourTag"
```

## Generating Allure Reports

1. Generate Allure results:
```bash
mvn clean test
```

2. Open Allure report:
```bash
mvn allure:serve
```

3. Generate static report:
```bash
mvn allure:report
```

The report will be available in `target/site/allure-maven-plugin/index.html`

## Features

- **Page Object Model (POM)** - Organized test structure
- **Cucumber BDD** - Write tests in plain English using Gherkin syntax
- **TestNG Integration** - Powerful test configuration and parallel execution
- **Allure Reporting** - Detailed test execution reports with screenshots
- **Data-Driven Testing** - Support for test data management
- **Cross-Browser Testing** - Support for multiple browsers
- **Screenshot Capture** - Automatic screenshot capture on test failure

## Configuration

Configuration files are located in `src/test/resources/`:

- `framework.properties` - Framework configuration settings
- `allure.properties` - Allure report configuration

## Writing Tests

### Cucumber Feature File Example:
```gherkin
Feature: Login functionality
  
  Scenario: Successful login
    Given User is on login page
    When User enters valid credentials
    Then User should be logged in successfully
```

### Step Definition Example:
```java
@Given("User is on login page")
public void userIsOnLoginPage() {
    // Implementation
}
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## Best Practices

- Keep test cases independent and atomic
- Use meaningful test data
- Follow naming conventions for test methods and feature files
- Write clear and concise step definitions
- Use appropriate wait strategies instead of hard waits
- Maintain test data separately from test logic

## Troubleshooting

### Common Issues:

1. **Browser driver not found**: Ensure the correct WebDriver is installed and configured
2. **Test failures**: Check logs in `target/surefire-reports/`
3. **Report generation issues**: Verify Allure is properly configured in `pom.xml`
