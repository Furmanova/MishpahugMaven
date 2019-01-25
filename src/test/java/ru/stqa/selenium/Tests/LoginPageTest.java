package ru.stqa.selenium.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.DataProviders;
import ru.stqa.selenium.pages.AuthEventsPageHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.MenuPageHelper;
import util.LogLog4j;

public class LoginPageTest extends TestBase {

    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;
    private AuthEventsPageHelper authEventsPage;
    private MenuPageHelper menuPageHelper;
   // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver,
                HomePageHelper.class);
        loginPageHelper = PageFactory.initElements(driver,
                LoginPageHelper.class);
        authEventsPage = PageFactory.initElements(driver,
                AuthEventsPageHelper.class);
        menuPageHelper = PageFactory.initElements(driver, MenuPageHelper.class);
        driver.get(baseUrl);
        Log.info("LoginTests BeforeMethod: homePage is loaded");
        homepage.waitUntilPageIsLoaded()
                .pressLoginButton();
        Log.info("LoginTests BeforeMethod: lodinPage is loaded");
        loginPageHelper.waitUntilPageIsLoaded();

    }

    @Test(groups = {"smoke", "regression"}, dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorization")
    public void loginPositive(String email, String password) {
        Log.info("--------Test loginPositive was Start-----");
        Log.info("---Parameter email:" + email);
        Log.info("---Parameter password:" + password);
        Log.info("TestLoginPositive: loginPage is Loaded");
        loginPageHelper.enterEmail(email)
                .enterPassword(password)
                .pressSubmitButton();
       authEventsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(authEventsPage.isHeaderCorrect("Find event"));
        Assert.assertTrue(authEventsPage.isDisplayedIconMenu());
        authEventsPage.hamburgerIcon();
        menuPageHelper.waitUntilPageLoaded()
                .pressLogOutButton();

    }

}

