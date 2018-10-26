package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import com.qa_test_lab.web.base.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogueMenuDetailedPanel extends AbstractPanel {
    private static final String CATEGORY_PANEL_ROOT_CSS = "li.f-menu-sub";

    public CatalogueMenuDetailedPanel(WebDriver driver) {
        super(driver, By.cssSelector(".f-menu-l-i.hover .f-menu-cols-b"));
    }

    public void clickCategoryTitle(int index) {
        List<WebElement> categoryTitles = WebHelper.findElements(findRootElement(),
                By.cssSelector(CATEGORY_PANEL_ROOT_CSS + " .f-menu-sub-title-link"));
        if (index >= categoryTitles.size()) {
            throw new IllegalArgumentException(String.format("Max category index is %s, when requested %s",
                    categoryTitles.size(), index));
        }
        categoryTitles.get(index).click();
    }
    public void clickCategoryItem(int categoryIndex, int itemIndexWithinCategory) {
        List<WebElement> categoriesPanels = WebHelper.findElements(findRootElement(),
                By.cssSelector(CATEGORY_PANEL_ROOT_CSS));
        if (categoryIndex >= categoriesPanels.size()) {
            throw new IllegalArgumentException(String.format("Max category index is %s, when requested %s",
                    categoriesPanels.size(), categoryIndex));
        }

        WebElement categoryPanel = categoriesPanels.get(categoryIndex);
        List<WebElement> categoryItems = WebHelper.findElements(categoryPanel, By.cssSelector("li.f-menu-sub-l-i"));

        if (itemIndexWithinCategory >= categoryItems.size()) {
            throw new IllegalArgumentException(String.format("Max category item index is %s, when requested %s" +
                            "\non category:" +
                            "\n" + categoryPanel.getText(),
                    categoryItems.size(), itemIndexWithinCategory));
        }
        categoryItems.get(itemIndexWithinCategory).click();
    }
}
