package ru.stqa.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FillProfileAccount extends PageBase {
    @FindBy(xpath = "//input[@ formcontrolname='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@ formcontrolname='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='inputPhoneNumber']")
    WebElement phone;
    @FindBy(xpath = "//mat-select[@id='mat-select-0']/div/div")
    WebElement confession;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Menu'])[1]/following::span[1]")
    WebElement confessionSelect;
    @FindBy(xpath = "//input[@id='inputDateOfBirth']")
    WebElement dateOfBirth;
    @FindBy(xpath = "\"//mat-select[@placeholder='Marital Status']//div[@class='mat-select-trigger']\")")
    WebElement maritalStatus;
    /*@FindBy(xpath = "//span[contains(text(),'Married')]")
    WebElement maritalStatusSelect;*/
    @FindBy(xpath = "//mat-select[@id='mat-select-12']//div/div")
    WebElement foodPreference;
    @FindBy(xpath = "//span[contains(text(),'Kosher')]")
    WebElement foodPreferenceSelect;
    @FindBy(xpath = "//span[@class='mat-select-placeholder ng-tns-c18-51 ng-star-inserted']")
    WebElement gender;
    @FindBy(xpath = "//span[contains(text(),'Male')]")
    WebElement genderSelect;
    @FindBy(xpath = "//span[@class='mat-select-placeholder ng-tns-c18-53 ng-star-inserted']")
    WebElement languages;
    @FindBy(xpath = "//span[contains(text(),'Russian')]")
    WebElement languagesSelect;
    @FindBy(xpath = "//textarea[@id='description']")
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
        waitUntilElementIsLoaded(driver, firstName, 40);
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

    /*public FillProfileAccount confession() {
        waitUntilElementIsLoaded(driver, confession, 40);
        enterClick(confession);
        // waitUntilElementIsLoaded(driver, confessionSelect, 40);
        // enterClick(confessionSelect);
        return this;
    }*/

    public FillProfileAccount confessionSelect() {
        waitUntilElementIsLoaded(driver, confession, 40);
        Actions action = new Actions(driver);
        action.moveToElement(confession).build().perform();
        enterClick(confession);
        enterClick(confessionSelect);

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
        Actions action = new Actions(driver);
        action.moveToElement(maritalStatus).build().perform();
        enterClick((maritalStatus));
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccount foodPreference() {
        enterClick(foodPreference);
        enterClick(foodPreferenceSelect);
        return this;
    }

    public FillProfileAccount gender() {
        enterClick(gender);
        enterClick(genderSelect);
        return this;
    }


    public FillProfileAccount languages() {
        enterClick(languages);
        enterClick(languagesSelect);
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
