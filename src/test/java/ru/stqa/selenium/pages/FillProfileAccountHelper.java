package ru.stqa.selenium.pages;


import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class FillProfileAccountHelper extends PageBase {
    @FindBy(xpath = "//input[@id='inputFirstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='inputLastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='inputPhoneNumber']")
    WebElement phone;
    @FindBy(xpath = "//mat-select[@placeholder='Confession']//div[@class='mat-select-trigger']")
    WebElement confession;

    @FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle']//button[@type='button']")
    WebElement dateOfBirth;
    @FindBy(xpath = "//mat-select[@placeholder='Marital Status']//div[@class='mat-select-trigger']")
    WebElement maritalStatus;
    @FindBy(xpath = "//mat-select[@id='mat-select-2']//div[@class='mat-select-value']")
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


    public FillProfileAccountHelper(WebDriver driver) {
        super(driver);
    }

    public FillProfileAccountHelper firstName(String value) {
        waitUntilElementIsLoaded(driver, firstName, 40);
        enterValueToField(firstName, value);
        return this;
    }

    public FillProfileAccountHelper lastName(String value) {
        enterValueToField(lastName, value);
        return this;
    }

    public FillProfileAccountHelper phoneNumber(String value) {
        enterValueToField(phone, value);
        return this;
    }

    public FillProfileAccountHelper confessionSelect(String value) throws InterruptedException {
        waitUntilElementIsLoaded(driver, confession, 40);
        Actions action = new Actions(driver);
        action.moveToElement(confession).build().perform();

        confession.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();

        return this;
    }

    public FillProfileAccountHelper dateOfBirth(int day, String month, int year) {
        waitUntilElementIsLoaded(driver, dateOfBirth, 40);
        Actions action = new Actions(driver);
        action.moveToElement(dateOfBirth).click().build().perform();
        //enterClick(dateOfBirth);

        driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']")).click();
        if (year < 2016) {
            driver.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
                }

        driver.findElement(By.xpath("//div[contains(text(),'" + year + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")).click();

        return this;
    }


    public FillProfileAccountHelper maritalStatus(String value) {
        waitUntilElementIsLoaded(driver, maritalStatus, 40);
        Actions action = new Actions(driver);
        action.moveToElement(maritalStatus).click().build().perform();
        // enterClick((maritalStatus));
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccountHelper foodPreference(String value) {
        waitUntilElementIsLoaded(driver, foodPreference, 40);
        Actions action = new Actions(driver);
        action.moveToElement(foodPreference).click().build().perform();
        //enterClick(foodPreference);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        action.sendKeys(Keys.ESCAPE).build().perform();
        return this;
    }

    public FillProfileAccountHelper gender(String value) {
        waitUntilElementIsLoaded(driver, gender, 40);
        Actions action = new Actions(driver);
        action.moveToElement(gender).click().build().perform();
        // enterClick(gender);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccountHelper languages(String value) {
        waitUntilElementIsLoaded(driver, languages, 40);
        Actions action = new Actions(driver);
        action.moveToElement(languages).click().build().perform();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        action.sendKeys(Keys.ESCAPE).build().perform();
        return this;
    }

    public FillProfileAccountHelper writeFewWordsAboutYourself(String value) {
        enterValueToField(writeFewWordsAboutYourself, value);
        return this;
    }

    public FillProfileAccountHelper cancelButton() {
        waitUntilElementIsLoaded(driver, cancelButton, 30);
        return this;
    }

    public void waitUntilPageIsLoaded() {
    }

    public FillProfileAccountHelper hamburgerIcon() {
        waitUntilElementIsLoaded(driver, iconMenu, 30);
        // iconMenu.click();
        return this;
    }
}
