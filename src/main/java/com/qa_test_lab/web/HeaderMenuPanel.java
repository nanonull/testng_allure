package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderMenuPanel extends AbstractPanel {
    public HeaderMenuPanel(WebDriver driver) {
        super(driver, By.className("header-user-buttons"));
    }

    public int getItemsInCartAmount() {
        return Integer.parseInt(getItemsInCart().getText());
    }

    private WebElement getItemsInCart() {
        return findRootElement().findElement(By.className("hub-i-count"));
    }
}
