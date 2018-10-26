package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {


    public static final String BASE_URL = "https://rozetka.com.ua";

    public HomePage(WebDriver driver) {
        super(driver, BASE_URL);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    public List<String> getProductCatalogueMainMenuRowNames() {
        return getProductCatalogueMainMenuRows()
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    private List<WebElement> getProductCatalogueMainMenuRows() {
        return driver.findElements(By.className("f-menu-l-i"));
    }

    private WebElement getSignInButton() {
        return driver.findElement(By.name("signin"));
    }

    private WebElement getProductCatalogueMainMenu() {
        return driver.findElement(By.id("fat-menu"));
    }


}
