package ru.stqa.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.LogLog4j;

/**
 * Sample page
 */
public class HomePageHelper extends PageBase {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    WebElement header;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventsButton;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public HomePageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        Log.info("HomePageHelper: wait until goToEventsButton is Loaded");
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Go to Event list')]"), 30);
        waitUntilElementIsLoaded(driver, goToEventsButton, 40);
        return this;

    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getLoginButtonName() {
        return loginButton.getText();
    }

    public String getCreateAccountName() {
        return createAccountButton.getText();
    }

    public String getGoToEventsButtonName() {
        return goToEventsButton.getText();
    }

    public HomePageHelper pressGoToEventButton() {
        goToEventsButton.click();
        return this;
    }

    public HomePageHelper pressLoginButton() {
        Log.info("HomePageHelper : pressLoginButton was presset");
        waitUntilElementIsLoaded(driver, loginButton, 40);
        loginButton.click();
        return this;
    }

    public HomePageHelper registrationButton() {
        waitUntilElementIsLoaded(driver, createAccountButton, 40);
        createAccountButton.click();
        return this;
    }


}