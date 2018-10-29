package com.qa_test_lab.web;

import com.qa_test_lab.web.base.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    public static final String BASE_URL = "https://rozetka.com.ua";

    @FindBy(className = "f-menu-l-i")
    private List<WebElement> productCatalogueMainMenuRows;
    @FindBy(css = "li.f-menu-l-i")
    private List<WebElement> menuItems;
    @FindBy(name = "signin")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver, BASE_URL);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public List<String> getProductCatalogueMainMenuRowNames() {
        return productCatalogueMainMenuRows
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public CatalogueMenuCategoriesPanel hoverCatalogueMenuItem(int index) {
        if (index >= menuItems.size()) {
            throw new IllegalArgumentException(String.format("Max menu item index is %s, when requested %s",
                    menuItems.size(), index));
        }
        Actions action = new Actions(driver);
        action.moveToElement(menuItems.get(index)).build().perform();
        return new CatalogueMenuCategoriesPanel(driver);
    }
}
