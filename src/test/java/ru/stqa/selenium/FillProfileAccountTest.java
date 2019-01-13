package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.TestBase;
import ru.stqa.selenium.pages.FillProfileAccountHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;

public class FillProfileAccountTest extends TestBase {
    private FillProfileAccountHelper fillProfileAccount;
    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        fillProfileAccount = PageFactory.initElements(driver, FillProfileAccountHelper.class);
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
        driver.get(baseUrl);
        homepage.pressLoginButton();
        loginPageHelper.enterEmail("furmanova@mail").enterPassword("Olga123").pressSubmitButton();
        fillProfileAccount.waitUntilPageIsLoaded();
    }

    @Test
    public void createAccountForm() throws InterruptedException {
        fillProfileAccount.confessionSelect("Irreligious")
                .languages("Russian")
                .maritalStatus("Married")
                .gender("Female")
                // .foodPreference("Kosher")
                .dateOfBirth(1 / 2 / 2019)

                .phoneNumber("950066841")
                .lastName("test")
                .firstName("Olga")
                .writeFewWordsAboutYourself("test")
                .cancelButton();
    }
}