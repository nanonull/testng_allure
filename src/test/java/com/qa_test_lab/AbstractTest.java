package com.qa_test_lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    static final String WEB_DRIVER_ATTRIBUTE = "webdriver";
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(ITestResult result) {
        setDriver();

        WebDriver.Options driverManage = driver.manage();
        driverManage.window().maximize();
        driverManage.timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverManage.timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driverManage.timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        result.setAttribute(WEB_DRIVER_ATTRIBUTE, driver);
    }

    private void setDriver() {
        String driverName = System.getProperty("browser");
        if ("chrome".equals(driverName)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("firefox".equals(driverName)) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unknown driver name: " + driverName);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        driver.close();
        driver = null;
    }
}
