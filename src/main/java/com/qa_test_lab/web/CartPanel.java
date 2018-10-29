package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPanel extends AbstractPanel {

    @FindBy(css = ".cart-i-content a[name=goods-link]")
    List<WebElement> cartItemsLinks;

    public CartPanel(WebDriver driver) {
        super(driver, By.id("cart-popup"));
    }

    public List<String> getProductIds() {
        List<String> ids = new ArrayList<>();
        for (WebElement cartItemLink : cartItemsLinks) {
            String link = cartItemLink.getAttribute("href");
            ids.add(link.replaceAll(HomePage.BASE_URL, ""));
        }
        return ids;
    }


}
