package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "incorrectLoginData")
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "dsewgw", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @DataProvider(name = "correctLoginData")
    public Object[][] correctLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Products"}
        };
    }

    @Test(dataProvider = "correctLoginData")
    public void chekCorrectLogin(String user, String password, String title) {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(productsPage.isTitleDisplayed());
        assertEquals(productsPage.getTitle(), title);
    }

    @Test(dataProvider = "incorrectLoginData")
    public void chekIncorrectLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMessage);
    }
}