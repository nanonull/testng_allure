package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogueMenuCategoriesPanel extends AbstractPanel {
    private static final String CATEGORY_PANEL_ROOT_CSS = "li.f-menu-sub";

    @FindBy(css = CATEGORY_PANEL_ROOT_CSS + " .f-menu-sub-title-link")
    private List<WebElement> categoryTitles;
    @FindBy(css = CATEGORY_PANEL_ROOT_CSS)
    private List<WebElement> categoriesPanels;

    public CatalogueMenuCategoriesPanel(WebDriver driver) {
        super(driver, By.name("second_menu"));
    }

    public void clickCategoryTitle(int index) {
        if (index >= categoryTitles.size()) {
            throw new IllegalArgumentException(String.format("Max category index is %s, when requested %s",
                    categoryTitles.size(), index));
        }
        categoryTitles.get(index).click();
    }

    public void clickCategoryItem(int categoryIndex, int itemIndexWithinCategory) {
        if (categoryIndex >= categoriesPanels.size()) {
            throw new IllegalArgumentException(String.format("Max category index is %s, when requested %s",
                    categoriesPanels.size(), categoryIndex));
        }

        WebElement categoryPanel = categoriesPanels.get(categoryIndex);
        By categoryItemsLocator = By.cssSelector("li.f-menu-sub-l-i");
        categoryPanel.findElement(categoryItemsLocator);
        List<WebElement> categoryItems = categoryPanel.findElements(categoryItemsLocator);

        if (itemIndexWithinCategory >= categoryItems.size()) {
            throw new IllegalArgumentException(String.format("Max category item index is %s, when requested %s" +
                            "\non category:" +
                            "\n" + categoryPanel.getText(),
                    categoryItems.size(), itemIndexWithinCategory));
        }
        categoryItems.get(itemIndexWithinCategory).click();
    }
}
