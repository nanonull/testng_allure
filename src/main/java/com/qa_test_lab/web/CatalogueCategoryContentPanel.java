package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogueCategoryContentPanel extends AbstractPanel {

    @FindBy(css = ".pab-h2-link")
    List<WebElement> titles;

    public CatalogueCategoryContentPanel(WebDriver driver) {
        super(driver, By.className("portal-automatic"));
    }

    public void clickCategoryRowTitle(int rowIndex) {
        if (rowIndex >= titles.size()) {
            throw new IllegalArgumentException(String.format("Max row index is %s, when %s was requested",
                    titles.size(), rowIndex));
        }
        titles.get(rowIndex).click();
    }
}
