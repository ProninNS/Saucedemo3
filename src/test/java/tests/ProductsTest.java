package tests;

import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    @Test()
    public void checkGoodsAdded() {
        List<String> goodsList =
                List.of(
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Bike Light",
                        "Sauce Labs Fleece Jacket");

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addGoodsToCart(5);

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        assertEquals(productsPage.chekCounterValue(), "rgba(226, 35, 26, 1)");
        assertEquals(productsPage.chekGoodsCount(), "3");
    }

    @Test
    public void chekGoodsAddedToBasket() {
        List<String> goodsList =
                List.of(
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Bike Light",
                        "Sauce Labs Fleece Jacket");

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
            productsPage.switchToBasket();

            assertTrue(basketPage.getProductsNames().equals(goodsList));
            assertTrue(basketPage.getProductsNames().contains("Sauce Labs Bike Light"));
        }
    }
}
