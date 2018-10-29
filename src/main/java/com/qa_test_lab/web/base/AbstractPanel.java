package com.qa_test_lab.web.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPanel {
    protected final WebDriver driver;
    protected final By baseLocator;

    public AbstractPanel(WebDriver driver, By baseLocator) {
        this.driver = driver;
        this.baseLocator = baseLocator;
        PageFactory.initElements(driver, this);
    }

    public WebElement findRootElement() {
        return driver.findElement(baseLocator);
    }

    public boolean isDisplayed() {
        try {
            return findRootElement().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
