package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateAccountHelper extends PageBase {

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@type = 'password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@ formcontrolname='passwordRep']")
    WebElement passwordRepeatField;
    @FindBy(xpath = "//span[contains(text(),'Registration')]")
    WebElement registrationButton;

    public CreateAccountHelper(WebDriver driver) {
        super(driver);
    }

    public CreateAccountHelper emailCreateAccount(String value) {
        enterValueToField(emailField, value);
        return this;
    }

    public CreateAccountHelper passwordCreateAccount(String value) {

        enterValueToField(passwordField, value);
        return this;
    }

    public CreateAccountHelper passwordRepeat(String value) {
        enterValueToField(passwordRepeatField, value);
        return this;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsLoaded(driver, registrationButton, 40);

    }
    public CreateAccountHelper registrationButton(){
        waitUntilElementIsLoaded(driver,registrationButton,40);
        registrationButton.click();
        return this;
    }
}