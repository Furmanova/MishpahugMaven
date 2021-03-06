package ru.stqa.selenium.pages;


import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;


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
    @FindBy(xpath = "//img[@id='borderRadius']")
    WebElement avatarChange;
    @FindBy(xpath = "//div[@class='classCentr']//button[2]//img[1]")
    WebElement bannerChange;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement eventsPage;
    @FindBy(xpath = "//span[contains(text(),'Change')]")
    WebElement clickChangeButton;
    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement myProfile;
    @FindBy(xpath = "//span[contains(text(),'Change')]")
    WebElement clickChngeButton;

    public FillProfileAccountHelper(WebDriver driver) {
        super(driver);
    }

    public FillProfileAccountHelper clickChngeButton() {
        waitUntilElementIsLoaded(driver, clickChangeButton, 40);
        Actions action = new Actions(driver);
        action.moveToElement(clickChangeButton).click().build().perform();
        return this;
    }

    public FillProfileAccountHelper myProfile() {
        waitUntilElementIsLoaded(driver, myProfile, 40);
        Actions action = new Actions(driver);
        action.moveToElement(myProfile).click().build().perform();
        //enterClick(myProfile);
        return this;
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
        action.moveToElement(confession).click().build().perform();
        // enterClick(confession);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccountHelper dateOfBirth(int day, String month, int year) {
        waitUntilElementIsLoaded(driver, dateOfBirth, 40);
        Actions action = new Actions(driver);
        action.moveToElement(dateOfBirth).click().build().perform();
        //enterClick(dateOfBirth);
        driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']")).click();
        WebElement iconButoon = driver.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']"));
        iconButoon.click();
        waitUntilElementIsLoaded(driver, iconButoon, 40);
        if (year < 2016) {
            iconButoon.click();
            waitUntilElementIsLoaded(driver, iconButoon, 40);
            if (year < 1968) {
                iconButoon.click();
                waitUntilElementIsLoaded(driver, iconButoon, 40);
            }
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
        // enterClick(foodPreference);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        action.sendKeys(Keys.ESCAPE).build().perform();
        return this;
    }

    public FillProfileAccountHelper gender(String value) {
        waitUntilElementIsLoaded(driver, gender, 40);
        Actions action = new Actions(driver);
        action.moveToElement(gender).click().build().perform();
        //enterClick(gender);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public FillProfileAccountHelper languages(String value) {
        waitUntilElementIsLoaded(driver, languages, 40);
        Actions action = new Actions(driver);
        action.moveToElement(languages).click().build().perform();
        // enterClick(languages);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        action.sendKeys(Keys.ESCAPE).build().perform();
        return this;
    }

    public FillProfileAccountHelper writeFewWordsAboutYourself(String value) {
        enterValueToField(writeFewWordsAboutYourself, value);
        return this;
    }

    public FillProfileAccountHelper cancelButton() {
        waitUntilElementIsLoaded(driver, eventsPage, 40);
        Actions action = new Actions(driver);
        action.moveToElement(cancelButton).click().build().perform();
        return this;
    }

    public FillProfileAccountHelper bannerChange() {
        waitUntilElementIsLoaded(driver, avatarChange, 40);
        Actions action = new Actions(driver);
        action.moveToElement(bannerChange).click().build().perform();
        //enterClick(bannerChange);
        File file = new File("src\\test\\resources\\Cats.jpg");
        WebElement fotoBanner = driver.findElement(By.xpath("//input[@type='file']"));
        fotoBanner.sendKeys(file.getAbsolutePath());
        waitUntilElementIsLoaded(driver, fotoBanner, 40);
        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        return this;
    }

    public FillProfileAccountHelper avatarChange() { //загрузка фото на аватар
        waitUntilElementIsLoaded(driver, avatarChange, 40);
        Actions action = new Actions(driver);
        action.moveToElement(avatarChange).click().build().perform();
        // enterClick(avatarChange);
        File file = new File("src\\test\\resources\\Cat.jpg");
        WebElement fotoAvatar = driver.findElement(By.xpath("//input[@type='file']"));
        fotoAvatar.sendKeys(file.getAbsolutePath());
        waitUntilElementIsLoaded(driver, fotoAvatar, 40);
        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        return this;
    }

    public FillProfileAccountHelper saveButton() {
        waitUntilElementIsLoaded(driver, eventsPage, 40);
        Actions action = new Actions(driver);
        action.moveToElement(saveButton).click().build().perform();
        return this;

    }

}