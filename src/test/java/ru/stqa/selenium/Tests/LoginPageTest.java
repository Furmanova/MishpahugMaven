package ru.stqa.selenium.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.DataProviders;
import ru.stqa.selenium.pages.AuthEventsPageHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.MenuPageHelper;

public class LoginPageTest extends TestBase {

    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;
    private AuthEventsPageHelper authEventsPage;
    private MenuPageHelper menuPageHelper;

    @BeforeMethod
    public void initPageObjects() {

        homepage = PageFactory.initElements(driver,
                HomePageHelper.class);
        loginPageHelper = PageFactory.initElements(driver,
                LoginPageHelper.class);
        authEventsPage = PageFactory.initElements(driver,
                AuthEventsPageHelper.class);
        driver.get(baseUrl);
        homepage.waitUntilPageIsLoaded()
                .pressLoginButton();
        loginPageHelper.waitUntilPageIsLoaded();
        menuPageHelper = PageFactory.initElements(driver, MenuPageHelper.class);
    }

    @Test(groups = {"smoke", "regression"}, dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorization")
    public void loginPositive(String email, String password) {
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

