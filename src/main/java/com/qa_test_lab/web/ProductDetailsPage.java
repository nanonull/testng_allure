package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(id = "price_label")
    private WebElement priceElement;

    @FindBy(name = "topurchases")
    private WebElement orderButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver, HomePage.BASE_URL);
    }

    public int getProductPrice() {
        return Integer.parseInt(priceElement.getText().replaceAll("[^\\d]", ""));
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Please use openByLink method");
    }

    public void openByLink(String productLink) {
        driver.get(baseUrl + "/" + productLink);
    }

    public boolean isOrderButtonDisplayed() {
        try {
            return orderButton.isDisplayed();
        } catch (NoSuchElementException exc) {
            return false;
        }
    }

    public void clickOrderButton() {
        orderButton.click();
    }

    public boolean isOpened() {
        // TODO: 26.10.2018 add better condition
        return isOrderButtonDisplayed();
    }
}
