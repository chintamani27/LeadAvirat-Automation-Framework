
# LeadAvirat Automation Testing Framework

A Selenium-based automation testing framework built using **Java, Selenium WebDriver, TestNG, and Maven** to validate the functionality of the LeadAvirat website.

The project follows the **Page Object Model (POM)** design pattern to maintain reusable, readable, and maintainable automation scripts.

## Project Overview

- **Project Name:** LeadAvirat Automation Framework
- **Application Under Test:** https://leadavirat.in/
- **Testing Type:** Web UI Automation Testing
- **Framework:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Build Tool:** Maven
- **Browser:** Microsoft Edge

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 23 | Programming Language |
| Selenium WebDriver 4.43.0 | Browser Automation |
| TestNG 7.11.0 | Test Execution and Assertions |
| Maven | Dependency Management |
| Eclipse IDE | Development Environment |
| Microsoft Edge | Browser for Testing |
| Git & GitHub | Version Control |

## Framework Architecture

```text
LeadAvirat-Automation-Framework
│
├── src/main/java
│   └── com.chintamani.leadavirat
│       ├── pages
│       │   ├── HomePage.java
│       │   ├── LoginPage.java
│       │   └── RegisterPage.java
│       │
│       └── utils
│           ├── ConfigReader.java
│           └── ScreenshotUtil.java
│
├── src/test/java
│   └── com.chintamani.leadavirat
│       ├── base
│       │   └── BaseTest.java
│       │
│       └── tests
│           ├── HomePageTest.java
│           ├── LoginTest.java
│           └── RegisterTest.java
│
├── src/test/resources
│   ├── config.properties
│   └── testng.xml
│
├── reports
├── screenshots
├── pom.xml
└── README.md
```

## Implemented Test Modules

### 1. Home Page Testing

- Verify home page loads successfully.
- Verify home page heading is displayed.

### 2. Login Page Testing

- Verify login page elements are displayed.
- Verify login with empty fields.
- Verify invalid email format validation.
- Verify password is masked.
- Verify Sign Up navigation.

### 3. Registration Page Testing

- Verify registration page elements.
- Verify password is masked.
- Verify minimum password length validation.
- Verify Sign In navigation.
- Verify empty registration form validation.
- Verify invalid email format validation.
- Verify required email field validation.
- Verify phone number field is optional.
- Verify phone number input and formatting behavior.

## Key Framework Features

- Page Object Model (POM) implementation.
- Reusable page classes and test methods.
- Centralized browser configuration using `config.properties`.
- BaseTest class for browser initialization and teardown.
- Explicit waits using WebDriverWait.
- TestNG assertions for result verification.
- Selenium locators using ID, CSS Selectors, and XPath.
- Browser-native HTML form validation testing.
- Reusable methods for interacting with web elements.

## Configuration

The framework uses `config.properties` to manage application settings.

```properties
baseUrl=https://leadavirat.in/
browser=edge
```

## How to Run the Project

**Prerequisites**

- Java JDK 23
- Maven
- Eclipse IDE
- Microsoft Edge browser

**Steps**

1. Clone the repository:

```bash
git clone https://github.com/chintamani27/LeadAvirat-Automation-Framework.git
```

2. Open the project in Eclipse as an existing Maven project.

3. Update Maven dependencies:

```bash
mvn clean install
```

4. Execute the TestNG test suite:

```bash
mvn test
```

Alternatively, right-click a TestNG test class in Eclipse and select **Run As → TestNG Test**.

## Current Project Status

| Module | Status |
|---|---|
| Framework Setup | Completed |
| Maven Configuration | Completed |
| BaseTest Setup | Completed |
| Home Page Testing | Implemented |
| Login Page Testing | Implemented |
| Registration Page Testing | In Progress |
| Forgot Password Testing | Pending |
| Contact Page Testing | Pending |
| Test Reports Integration | Pending |

## Future Enhancements

- Complete registration test coverage.
- Implement Forgot Password page automation.
- Implement Contact page automation.
- Add data-driven testing using TestNG DataProvider.
- Integrate automated screenshot capture on test failures.
- Generate detailed TestNG/Extent Reports.
- Implement cross-browser testing.
- Integrate the framework with Jenkins for CI/CD.

## Author

**Chintamani Dinkar Adak**

- GitHub: https://github.com/chintamani27
- LinkedIn: https://www.linkedin.com/in/chintamani-adak-044a572b2/

---

*This project is developed for learning and demonstrating practical Selenium automation testing, framework design, and web application validation.*
