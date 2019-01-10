package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsLoaded(driver, cancelButton, 40);
        return this;
    }

    public boolean isLoginPageOpened() {
        System.out.println("text: " + registrationControl.getText());
        return registrationControl.getText().equals("Still don't have account? Registration");
    }

    public LoginPageHelper enterEmail(String value) {
        waitUntilElementIsLoaded(driver,emailField,30);
        enterValueToField(emailField, value);
        return this;
    }

    public LoginPageHelper enterPassword(String value) {
        enterValueToField(passwordField, value);
        return this;
    }

    public LoginPageHelper pressSubmitButton() {
        waitUntilElementIsLoaded(driver, submitButton, 30);
        Actions action = new Actions(driver);
        action.moveToElement(submitButton).build().perform();
        submitButton.click();
        return this;
    }


}