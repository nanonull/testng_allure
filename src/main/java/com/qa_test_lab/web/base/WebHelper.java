package com.qa_test_lab.web.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebHelper {

    public static List<WebElement> findElements(WebDriver driver, By by) {
        return WebHelper.findElements(driver.findElement(By.xpath("*")), by);
    }

    public static List<WebElement> findElements(WebElement rootElement, By by) {
        // hack:
        // find at least 1 element using implicit wait before call findElements,
        // because findElements doesnt use implicit wait (it can return 0 elements)
        rootElement.findElement(by);
        return rootElement.findElements(by);
    }
}
