# Introduction:
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG, which can be used across different web based applications. With this framework in place, whenever we need to automate a web based application, we would not need to start from scratch. Currently the test cases automated in the project are for Gurukula sample website.

# Prerequisites
* Java jdk1.8
* Maven 3 or higher
* Gurukula war up and running

# Execution
* Clone the repository
* Open command prompt and go to project directory
* Run maven command mvn clean install

# Logging
* Logging is implement using log4j
* Configuration file name is log4j.properties
* Logs will be generated in //logs/selenium.logs

# Screenshots
* captureScreen method is created to capture screenshots located in //src/test/java/testbase/TestBase.java
* Screenshots will be saved in //Screenshots folder

# Reading Excel
*Apache POI is used to read excel and implement data driven testing

# Page object Model and Page Factory
* Page Object Model is used to create Object Repository for web UI elements. 
* Under this model, for each web page in the application, there should be corresponding page class. 
* The Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

# Reporting
* The framework produces TestNg reports
* Advance reporting using Extent report is also implemented. You can find the reports in //test-output folder with name Test-Report-<date-time>.html
* Screenshots can be attached to the report if test cases fails
* Pie charts for overview and details are available




