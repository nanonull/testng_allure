TestNG + Allure example

Run tests in chrome:
mvn clean test site -Dbrowser=chrome
Or Run tests in firefox:
mvn clean test site -Dbrowser=firefox

To open generated allure report:
mvn io.qameta.allure:allure-maven:serve
