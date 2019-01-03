package ru.stqa.selenium.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.TestBase;

public class LoginPage extends TestBase {

    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;
    private AuthEventsPageHelper authEventsPage;

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
    }

    @Test
    public void loginPositive() {
        loginPageHelper.enterEmail("marina@123.com")
        .enterPassword("marina")
        .pressSubmitButton();
        authEventsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(authEventsPage.isHeaderCorrect("Find event"));
        Assert.assertTrue(authEventsPage.isDisplayedIconMenu());

    }
}

