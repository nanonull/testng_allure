package com.qa_test_lab.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected final WebDriver driver;
    protected final String baseUrl;

    public AbstractPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(baseUrl);
    }
}
