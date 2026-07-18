package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products");

        productsPage.addGoodsToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addGoodsToCart(0);
        assertEquals(productsPage.chekCounterValue(), "rgba(226, 35, 26, 1)");
    }
}
