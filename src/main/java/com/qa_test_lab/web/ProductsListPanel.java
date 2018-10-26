package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import com.qa_test_lab.web.base.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsListPanel extends AbstractPanel {
    public ProductsListPanel(WebDriver driver) {
        super(driver, By.id("catalog_goods_block"));

    }

    public void clickProduct(int index) {
        List<WebElement> products = WebHelper.findElements(findRootElement(),
                By.cssSelector(".g-i-tile-i .g-i-tile-i-box"));
        if (index >= products.size()) {
            throw new IllegalArgumentException(String.format("Max product index is %s, when requested %s",
                    products.size(), index));
        }
        products.get(index).click();
    }
}
