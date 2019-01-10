package ru.stqa.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FillProfileAccount extends PageBase {
    @FindBy(xpath = "//input[@id='inputFirstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='inputLastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='inputPhoneNumber']")
    WebElement phone;
    @FindBy(xpath = "//mat-select[@placeholder='Confession']//div[@class='mat-select-trigger']")
    WebElement confession;

    @FindBy(css = "svg.mat-datepicker-toggle-default-icon.ng-star-inserted")
    WebElement dateOfBirth;
    @FindBy(xpath = "//mat-select[@placeholder='Marital Status']//div[@class='mat-select-trigger']")
    WebElement maritalStatus;
    @FindBy(xpath = "//mat-select[@placeholder='Food Preferences']//div[@class='mat-select-trigger']")
    WebElement foodPreference;

    @FindBy(xpath = "//mat-select[@placeholder='Gender']//div[@class='mat-select-trigger']")
    WebElement gender;

    @FindBy(xpath = "//mat-select[@placeholder='Languages']//div[@class='mat-select-trigger']")
    WebElement languages;

    @FindBy(css = "#description")
    WebElement writeFewWordsAboutYourself;
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement iconMenu;
    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement myProfile;

    public FillProfileAccount(WebDriver driver) {
        super(driver);
    }

    public FillProfileAccount clickMyProfile() {
        myProfile.click();
        return this;
    }

    public FillProfileAccount firstName(String value) {
        // waitUntilElementIsLoaded(driver, firstName, 40);
        enterValueToField(firstName, value);
        return this;
    }

    public FillProfileAccount lastName(String value) {
        enterValueToField(lastName, value);
        return this;
    }

    public FillProfileAccount phoneNumber(String value) {
        enterValueToField(phone, value);
        return this;
    }

    public FillProfileAccount confessionSelect(String value) throws InterruptedException {
        waitUntilElementIsLoaded(driver, confession, 40);

        Actions action = new Actions(driver);
        action.moveToElement(confession).build().perform();
        confession.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccount dateOfBirth(String value) {

        Actions action = new Actions(driver);
        action.moveToElement(dateOfBirth).build().perform();
        enterClick(dateOfBirth);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='JAN'])[1]/following::div[9]")).click();

        return this;
    }

    public FillProfileAccount maritalStatus(String value) {
        waitUntilElementIsLoaded(driver, maritalStatus, 40);
        Actions action = new Actions(driver);
        action.moveToElement(maritalStatus).build().perform();
        enterClick((maritalStatus));
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccount foodPreference(String value) {
        Actions action = new Actions(driver);
        action.moveToElement(foodPreference).build().perform();
        enterClick(foodPreference);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccount gender(String value) {
        Actions action = new Actions(driver);
        action.moveToElement(gender).build().perform();
        enterClick(gender);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }


    public FillProfileAccount languages(String value) {
        Actions action = new Actions(driver);
        action.moveToElement(languages).build().perform();
        enterClick(languages);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccount writeFewWordsAboutYourself(String value) {
        enterValueToField(writeFewWordsAboutYourself, value);
        return this;
    }

    public FillProfileAccount cancelButton() {
        waitUntilElementIsLoaded(driver, cancelButton, 30);
        return this;
    }

    public void waitUntilPageIsLoaded() {
    }

    public FillProfileAccount hamburgerIcon() {
        waitUntilElementIsLoaded(driver, iconMenu, 30);
        iconMenu.click();
        return this;
    }
}
