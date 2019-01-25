package ru.stqa.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.rmi.runtime.Log;
import util.LogLog4j;

public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    WebElement cancelButton;

    @FindBy(xpath = "//div[@class='reg']")
    WebElement registrationControl;

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

   // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        Log.info("LoginTests BeforeMethod: homePage is loaded");
        waitUntilElementIsLoaded(driver, cancelButton, 40);
        return this;
    }

    public boolean isLoginPageOpened() {
        System.out.println("text: " + registrationControl.getText());
        return registrationControl.getText().equals("Still don't have account? Registration");
    }

    public LoginPageHelper enterEmail(String value) {
        Log.info("----LoginPageHelper: method enterEmail was started----");
        Log.info("LoginPageHelper enterEmail:" + value + "to emailField");
        waitUntilElementIsLoaded(driver,emailField,30);
        enterValueToField(emailField, value);
        return this;
    }

    public LoginPageHelper enterPassword(String value) {
        Log.info("----LoginPageHelper: method enterPassword was started----");
        Log.info("LoginPageHelper enterPassword:" + value + "to passwordField");
        enterValueToField(passwordField, value);
        return this;
    }

    public LoginPageHelper pressSubmitButton() {
        Log.info("----LoginPageHelper: method pressSubmitButton was started----");
        Log.info("LoginPageHelper wait until submitButton was loaded:");
        waitUntilElementIsLoaded(driver, submitButton, 50);
        Actions action = new Actions(driver);
        action.moveToElement(submitButton).build().perform();
        submitButton.click();
        return this;
    }


}