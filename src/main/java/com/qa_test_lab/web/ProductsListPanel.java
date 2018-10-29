package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsListPanel extends AbstractPanel {
    @FindBy(css = ".g-i-tile-i .g-i-tile-i-box")
    private List<WebElement> products;

    public ProductsListPanel(WebDriver driver) {
        super(driver, By.id("catalog_goods_block"));

    }

    public void clickProduct(int index) {
        if (index >= products.size()) {
            throw new IllegalArgumentException(String.format("Max product index is %s, when requested %s",
                    products.size(), index));
        }
        products.get(index).click();
    }
}
