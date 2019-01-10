package ru.stqa.selenium.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.TestBase;

public class FillProfileAccountTest extends TestBase {
    private FillProfileAccount fillProfileAccount;
    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        fillProfileAccount = PageFactory.initElements(driver, FillProfileAccount.class);
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
        driver.get(baseUrl);
        homepage.pressLoginButton();
        loginPageHelper.enterEmail("furmanova@mail").enterPassword("Olga123").pressSubmitButton();
        fillProfileAccount.waitUntilPageIsLoaded();
    }

    @Test
    public void createAccountForm() throws InterruptedException {

        fillProfileAccount.hamburgerIcon()
                .clickMyProfile()

                .confessionSelect("Irreligious")
                //.gender("Female")
                .foodPreference("Any")
                .maritalStatus("Married")
                //.languages("Russian")
                .firstName("Olga")
                .lastName("test")
                .phoneNumber("950066841")
                //.dateOfBirth("2019-01-06")
                .writeFewWordsAboutYourself("test")
                .cancelButton();
    }
}