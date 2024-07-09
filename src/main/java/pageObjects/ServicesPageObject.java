package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ServicesPageUI;

public class ServicesPageObject extends BasePage {
    public ServicesPageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public boolean isGaroonServicesDisplayed() {
        waitForElementVisible(driver, ServicesPageUI.SERVICES_GAROON_LINK);
        return isElementDisplayed(driver,ServicesPageUI.SERVICES_GAROON_LINK);
    }

    public void clickToGaroonServices() {
        waitForElementClickable(driver, ServicesPageUI.SERVICES_GAROON_LINK);
        clickToElement(driver, ServicesPageUI.SERVICES_GAROON_LINK);
    }
}
