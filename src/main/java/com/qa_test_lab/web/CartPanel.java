package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPanel extends AbstractPanel {
    public CartPanel(WebDriver driver) {
        super(driver, By.id("cart-popup"));
    }


}
