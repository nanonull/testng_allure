package com.qa_test_lab.web.checkout;

import com.qa_test_lab.web.base.AbstractPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemoveCartItemPanel extends AbstractPanel {

    @FindBy(className = "cart-i-delete")
    private WebElement removeButton;

    public RemoveCartItemPanel(WebDriver driver) {
        super(driver, By.name("popup-move"));
    }

    public void clickRemoveButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateStaleElements();
        removeButton.click();
    }
}
