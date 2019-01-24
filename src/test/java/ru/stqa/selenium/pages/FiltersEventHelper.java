package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class FiltersEventHelper extends PageBase {
    @FindBy(xpath = "//button[@class='mat-raised-button']")
    WebElement clickFiltersButoon;
    @FindBy(css = "svg.mat-datepicker-toggle-default-icon.ng-star-inserted")
    WebElement fromDateCalendar;
    @FindBy(xpath = "//mat-form-field[@class='mat-input-container mat-form-field ng-tns-c20-9 mat-primary mat-form-field-type-mat-input mat-form-field-can-float mat-form-field-hide-placeholder ng-pristine ng-valid ng-touched']//span[@class='mat-form-field-label-wrapper mat-input-placeholder-wrapper mat-form-field-placeholder-wrapper']")
    WebElement toDateCalendar;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Holiday'])[1]/following::div[2]")
    WebElement holiday;
    @FindBy(xpath = "//mat-select[@placeholder='Confession']//div[@class='mat-select-trigger']")
    WebElement confession;
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

    public FiltersEventHelper fromDateCalendar(int day, String month, int year) {
        waitUntilElementIsLoaded(driver,fromDateCalendar,40);
        Actions action = new Actions(driver);
        action.moveToElement(fromDateCalendar).click().build().perform();
        driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + year + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")).click();

        return this;
    }

    public FiltersEventHelper toDateCalendar(int day, String month, int year) {
        waitUntilElementIsLoaded(driver,toDateCalendar,40);
        Actions action = new Actions(driver);
        action.moveToElement(toDateCalendar).click().build().perform();
        driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + year + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")).click();

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
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Food preferences'])[1]/following::div[2]")).click();
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
