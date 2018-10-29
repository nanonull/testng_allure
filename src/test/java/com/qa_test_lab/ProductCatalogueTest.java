package com.qa_test_lab;

import com.qa_test_lab.web.*;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class ProductCatalogueTest extends AbstractTest {

    @Test
    public void testUserCanSeeProductCatalogue() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assertions.assertThat(homePage.getProductCatalogueMainMenuRowNames())
                .as("Product Catalogue Main Menu Rows mismatch")
                .hasSize(17);
    }

    @Test
    public void testNavigateToProductDetailsUsingCatalogue() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CatalogueMenuDetailedPanel catalogueMenuDetailedPanel = homePage.hoverCatalogueMenuItem(0);
        catalogueMenuDetailedPanel.clickCategoryTitle(0);

        CatalogueCategoryContentPanel categoryContentPanel = new CatalogueCategoryContentPanel(driver);
        categoryContentPanel.clickCategoryRowTitle(0);

        ProductsListPanel productsListPanel = new ProductsListPanel(driver);
        productsListPanel.clickProduct(0);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        Assertions.assertThat(productDetailsPage.isOpened())
                .as("Product details should be opened").isTrue();
    }

    @Test
    public void testNavigateToProductDetailsUsingCatalogueItem() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CatalogueMenuDetailedPanel catalogueMenuDetailedPanel = homePage.hoverCatalogueMenuItem(14);
        catalogueMenuDetailedPanel.clickCategoryItem(8, 2);

        ProductsListPanel productsListPanel = new ProductsListPanel(driver);
        productsListPanel.clickProduct(31);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        Assertions.assertThat(productDetailsPage.isOpened())
                .as("Product details should be opened").isTrue();
    }


}

