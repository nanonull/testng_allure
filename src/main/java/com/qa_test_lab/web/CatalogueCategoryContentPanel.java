package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import com.qa_test_lab.web.base.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogueCategoryContentPanel extends AbstractPanel {
    public CatalogueCategoryContentPanel(WebDriver driver) {
        super(driver, By.className("portal-automatic"));
    }

    public void clickCategoryRowTitle(int rowIndex) {
        List<WebElement> titles = WebHelper.findElements(findRootElement(), By.cssSelector(".pab-h2-link"));
        if (rowIndex >= titles.size()) {
            throw new IllegalArgumentException(String.format("Max row index is %s, when %s was requested",
                    titles.size(), rowIndex));
        }
        titles.get(rowIndex).click();
    }
}
