package com.qa_test_lab.web.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class AbstractPanel {
    protected final WebDriver driver;
    private final By baseLocator;

    public AbstractPanel(WebDriver driver, By baseLocator) {
        this.driver = driver;
        this.baseLocator = baseLocator;
        initElements();
    }

    public void updateStaleElements() {
        initElements();
    }
    private void initElements() {
        DefaultElementLocatorFactory locatorFactory = new DefaultElementLocatorFactory(driver.findElement(baseLocator));
        PageFactory.initElements(locatorFactory, this);
    }

    protected WebElement findRootElement() {
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
