package com.qa_test_lab;

import com.qa_test_lab.base.AbstractTest;
import com.qa_test_lab.base.TestListener;
import com.qa_test_lab.stub.Database;
import com.qa_test_lab.web.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class ProductCatalogueTest extends AbstractTest {

    @Test
    public void viewProductCatalogueMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assertions.assertThat(homePage.getProductCatalogueMainMenuRowNames())
                .as("Product Catalogue Main Menu Rows mismatch")
                .hasSize(Database.getMenuItemsAmount());
    }

    @Test
    public void navigateToProductDetailsUsingCatalogue() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CatalogueMenuCategoriesPanel catalogueMenuCategoriesPanel = homePage.hoverCatalogueMenuItem(0);
        catalogueMenuCategoriesPanel.clickCategoryTitle(0);

        CatalogueCategoryContentPanel categoryContentPanel = new CatalogueCategoryContentPanel(driver);
        categoryContentPanel.clickCategoryRowTitle(0);

        ProductsListPanel productsListPanel = new ProductsListPanel(driver);
        productsListPanel.clickProduct(0);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        Assertions.assertThat(productDetailsPage.isOpened())
                .as("Product details should be opened").isTrue();
    }


}

