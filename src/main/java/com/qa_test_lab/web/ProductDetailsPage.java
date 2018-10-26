package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends AbstractPage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver, HomePage.BASE_URL);
    }

    public int getProductPrice() {
        return Integer.parseInt(getPriceElement().getText().replaceAll("[^\\d]", ""));
    }

    private WebElement getPriceElement() {
        return driver.findElement(By.id("price_label"));
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Please use openByLink method");
    }

    public void openByLink(String productLink) {
        driver.get(baseUrl + "/" + productLink);
    }

    public void clickOrderButton() {
        getOrderButton().click();
    }

    private WebElement getOrderButton() {
        return driver.findElement(By.name("topurchases"));
    }
}
