package ru.stqa.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthEventsPageHelper extends PageBase {
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement iconMenu;

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filterButton;

    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement headerPage;


    public AuthEventsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
       waitUntilElementIsLoaded(driver, filterButton, 40);

    }

    public boolean isHeaderCorrect(String value) {
        return headerPage.getText().equals(value);
    }

    public boolean isDisplayedIconMenu() {
        return iconMenu.getAttribute("mattooltip").equals("Menu");
    }

    public void hamburgerIcon() {
        waitUntilElementIsLoaded(driver, iconMenu, 40);
        iconMenu.click();
    }

}