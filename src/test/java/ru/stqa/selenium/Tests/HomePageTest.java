package ru.stqa.selenium.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.UnAuthEventsPageHelper;

public class HomePageTest extends TestBase {
    private HomePageHelper homepage;
    private UnAuthEventsPageHelper unAuthEventsPageHelper;
    private LoginPageHelper loginPageHelper;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver,
                HomePageHelper.class);
        unAuthEventsPageHelper = PageFactory.initElements(driver,
                UnAuthEventsPageHelper.class);
        loginPageHelper = PageFactory.initElements(driver,
                LoginPageHelper.class);
        driver.get(baseUrl);
    }

    @Test
    public void openHomePageTest() {
        homepage.waitUntilPageIsLoaded();
        Assert.assertEquals(homepage.getHeaderText(),
                "Shabbat in the family circle");
    }

    @Test
    public void contentPageUnAuthTest() {
        homepage.waitUntilPageIsLoaded();
        int counter = 0;
        if (homepage.getHeaderText()
                .equals("Shabbat in the family circle")) counter++;
        if (homepage.getLoginButtonName().equals("Login")) counter++;
        if (homepage.getCreateAccountName().equals("Create Account")) counter++;
        if (homepage.getGoToEventsButtonName().equals("Go to Event list")) counter++;
        Assert.assertEquals(counter,4);
    }

    @Test
    public void goToEventsPageTest() {
        homepage.waitUntilPageIsLoaded();
        homepage.pressGoToEventButton();
        unAuthEventsPageHelper.waitUntilPageIsLoaded();
        Assert.assertTrue(unAuthEventsPageHelper.isHedearCorrect("Find event"));

    }

    @Test
    public void goLoginPageTest() {
        homepage.waitUntilPageIsLoaded();
        homepage.pressLoginButton()
                .waitUntilPageIsLoaded();
        Assert.assertTrue(loginPageHelper.isLoginPageOpened());
    }
}

