package ru.stqa.selenium.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.AuthEventsPageHelper;
import ru.stqa.selenium.pages.CreateAccountHelper;
import ru.stqa.selenium.pages.HomePageHelper;

public class CreateAccountPageTest extends TestBase {
    private HomePageHelper homepage;
    private CreateAccountHelper createAccountHelper;
    private AuthEventsPageHelper authEventsPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver,
                HomePageHelper.class);
        createAccountHelper = PageFactory.initElements(driver, CreateAccountHelper.class);
        authEventsPage = PageFactory.initElements(driver, AuthEventsPageHelper.class);
        driver.get(baseUrl);
        homepage.waitUntilPageIsLoaded()
                .registrationButton();
        createAccountHelper.waitUntilPageIsLoaded();

    }

    @Test
    public void createAccountPositive() {

        createAccountHelper.emailCreateAccount("furmano@mail")
        .passwordCreateAccount("Olga123")
        .passwordRepeat("Olga123")
        .registrationButton();

    }
}