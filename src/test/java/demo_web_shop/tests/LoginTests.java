package demo_web_shop.tests;

import demo_web_shop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    final String EMAIL = "mailvvc@gmail.com"; //System.currentTimeMillis() + "@gmail.com" //генератор случайного email;
    final String PASSWORD = "mailvvc@gmail.com";

    @BeforeMethod
    public void precondition() {
        createNewUser(EMAIL, PASSWORD);
    }

    private void createNewUser(String email, String password) {

    }

    @Test
    public void login() {
        clickOnLoginLink();
        enterPersonalData(EMAIL, PASSWORD);
        clickOnLoginButton();
        Assert.assertTrue(isLogOutButtonPresent());
    }
}
