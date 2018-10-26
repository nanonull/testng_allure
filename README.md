TestNG + Allure example

1.
Run tests in chrome:
mvn clean test site -Dbrowser=chrome
Or Run tests in firefox:
mvn clean test site -Dbrowser=firefox

...using suite (don't specify to run all tests):
-Dsurefire.suiteXmlFiles=suites/catalogue.xml


2.
To open generated allure report:
mvn io.qameta.allure:allure-maven:serve


Test assumptions:
- we know how to find product in corresponding lists (catalog > submenu > product list)

TODO:
Add screenshot on failure
Hide driver from tests code
Factory for pages and panels
