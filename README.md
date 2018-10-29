TestNG + Allure example

1. Run tests and generate report
...in chrome:
mvn clean test site -Dbrowser=chrome
...or in firefox:
mvn clean test site -Dbrowser=firefox

...using suite (skip this property to run all tests):
-Dsurefire.suiteXmlFiles=suites/catalogue.xml

...or run single test method with:
-Dtest=ProductCatalogueTest#testUserCanSeeProductCatalogue


2. Open allure report:
mvn io.qameta.allure:allure-maven:serve

For example full cmd can look like:
mvn clean compile test -Dtest=ProductCatalogueTest#testUserCanSeeProductCatalogue -Dbrowser=chrome site io.qameta.allure:allure-maven:serve


Test assumptions:
- we know how to find product in corresponding shop lists (catalog > submenu > product list)

TODO:
Add screenshot on failure
Hide driver from tests code
Factory for pages and panels
