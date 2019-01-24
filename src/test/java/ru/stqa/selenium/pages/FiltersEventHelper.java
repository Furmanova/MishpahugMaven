package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class FiltersEventHelper extends PageBase {
    @FindBy(xpath = "//button[@class='mat-raised-button']")
    WebElement clickFiltersButoon;
    @FindBy(css = "svg.mat-datepicker-toggle-default-icon.ng-star-inserted")
    WebElement fromDateCalendar;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::div[4]")
    WebElement toDateCalendar;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Holiday'])[1]/following::div[2]")
    WebElement holiday;
    @FindBy(xpath = "//mat-select[@placeholder='Confession']//div[@class='mat-select-trigger']")
    WebElement confession;
    @FindBy(xpath = "")
    WebElement foodPreferences;
    @FindBy(xpath = "")
    WebElement resetClickButton;
    @FindBy(xpath = "")
    WebElement okClickButton;
    @FindBy(xpath = "")
    WebElement cancelClickButton;

    public FiltersEventHelper(WebDriver driver) {
        super(driver);
    }

    public FiltersEventHelper clickFiltersButoon() {
        waitUntilElementIsLoaded(driver,clickFiltersButoon,40);
        Actions action = new Actions(driver);
        action.moveToElement(clickFiltersButoon).click().build().perform();
        return this;
    }

    public FiltersEventHelper fromDateCalendar() {
        waitUntilElementIsLoaded(driver,fromDateCalendar,40);
        Actions action = new Actions(driver);
        action.moveToElement(fromDateCalendar).click().build().perform();
        return this;
    }

    public FiltersEventHelper toDateCalendar() {
        waitUntilElementIsLoaded(driver,toDateCalendar,40);
        Actions action = new Actions(driver);
        action.moveToElement(toDateCalendar).click().build().perform();
        return this;
    }

    public FiltersEventHelper holidayFilters(String value)  {
        waitUntilElementIsLoaded(driver, holiday, 40);
        Actions action = new Actions(driver);
        action.moveToElement(holiday).click().build().perform();

      driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();

        return this;
    }

    public FiltersEventHelper confessionFilters(String value) {
        waitUntilElementIsLoaded(driver, confession, 40);
        Actions action = new Actions(driver);
        action.moveToElement(confession).click().build().perform();

        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();

        return this;
    }

    public FiltersEventHelper foodPreferences() {
        return this;
    }

    public FiltersEventHelper resetClickButton() {
        return this;
    }

    public FiltersEventHelper okClickButton() {
        return this;
    }

    public FiltersEventHelper cancelClickButton() {
        return this;
    }
}
