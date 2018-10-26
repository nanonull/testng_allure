package com.qa_test_lab.web.base;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final WebDriver driver;
    protected final String baseUrl;

    public AbstractPage(WebDriver driver, String baseUrl) {

        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void open() {
        driver.get(baseUrl);
    }
}
