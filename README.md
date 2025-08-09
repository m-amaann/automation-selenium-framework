# AUTOMATION TESTING FRAMEWORK

This is a robust, scalable, and extensible Test Automation Framework using **Java**, **TestNG**, **Selenium**, *
*ExtentReports**, and other modern tools. Designed for both UI and API testing with support for HTML reporting and
logging.

---

### 📦 Dependencies

| Dependency         | Version  | Purpose                                                         |
|--------------------|----------|-----------------------------------------------------------------|
| `selenium-java`    | `4.30.0` | Core browser automation using Chrome, Firefox, etc.             |
| `testng`           | `7.10.2` | Test execution framework for grouping, parallel execution, etc. |
| `extentreports`    | `5.1.1`  | Beautiful HTML reports with screenshots, logs, test outcomes.   |
| `assertj-core`     | `3.25.3` | Fluent, readable assertion syntax.                              |
| `webdrivermanager` | `5.7.0`  | Automatically downloads and manages browser drivers.            |
| `rest-assured`     | `4.3.3`  | API testing for RESTful services.                               |
| `log4j-core`       | `2.24.3` | Logging of test events and debugging info.                      |

---

### 🧪 Running Tests

``` 
mvn clean install 
```

Run tests via TestNG:

``` 
mvn test 
```

### config.properties

``` 
base.url=
browser=chrome
headless=true
```

### Screenshots / Reports

ExtentReports dashboard, test result screenshots, and summary.

### UI mode

`
mvn clean test -Dbrowser=chrome -Dheadless=false
`

### Headless mode

`
mvn clean test -Dbrowser=chrome -Dheadless=true
`



