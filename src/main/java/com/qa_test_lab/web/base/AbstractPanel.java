package com.qa_test_lab.web.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPanel {
    protected final WebDriver driver;
    protected final By baseLocator;

    public AbstractPanel(WebDriver driver, By baseLocator) {
        this.driver = driver;
        this.baseLocator = baseLocator;
    }

    public WebElement getRootElement() {
        return driver.findElement(baseLocator);
    }

    public boolean isDisplayed() {
        try {
            return getRootElement().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
