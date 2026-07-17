package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text() = '%s']//ancestor::div[@class='inventory_item]" +
            "child::button[text() = 'Add to Cart']";
    private final By title = By.xpath("//*[@class='title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted("Sauce Labs Bolt T-Shirt"));
        return driver.findElement(addToCart).click();
    }
}