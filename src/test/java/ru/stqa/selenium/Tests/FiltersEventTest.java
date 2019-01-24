package ru.stqa.selenium.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;

public class FiltersEventTest extends TestBase {
    private HomePageHelper homepage;
    private LoginPageHelper loginPageHelper;
    private FiltersEventHelper filtersEventHelper;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
        filtersEventHelper = PageFactory.initElements(driver, FiltersEventHelper.class);
        driver.get(baseUrl);
        homepage.pressLoginButton();
        loginPageHelper.enterEmail("furmanova@mail").enterPassword("Olga123").pressSubmitButton();
    }

    @Test
    public void filtresEventTest() {
        filtersEventHelper.clickFiltersButoon()
                .fromDateCalendar(20, "FEB", 2020)
                //.toDateCalendar(25, "FEB",2023)
                .holidayFilters()
                .confessionFilters()
                .foodPreferences()
               // .resetClickButton()
               .okClickButton();
                //.cancelClickButton();

    }
}
