package commons;

import org.openqa.selenium.WebDriver;
import pageUIs.BaseElementUI;

public class BaseElement extends BasePage{
    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void selectDateTimeDropDown(String dateTime, String valueDropdown) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_SELECT_DATE_TIME_DROPDOWN,dateTime);
        selectItemInDropdown(driver, BaseElementUI.DYNAMIC_SELECT_DATE_TIME_DROPDOWN,valueDropdown,dateTime);
    }

    public boolean isDialogErrorMessageDisplayed(String errorMessage) {
        return isElementDisplayed(driver,BaseElementUI.DYNAMIC_DIALOG_ERROR_MESSAGE,errorMessage);
    }
}
