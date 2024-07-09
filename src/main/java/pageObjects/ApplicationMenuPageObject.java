package pageObjects;

import commons.BaseElement;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ApplicationMenuPageUI;

public class ApplicationMenuPageObject extends BaseElement {
    public ApplicationMenuPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public void openDynamicApplicationMenu(String application) {
        waitForElementClickable(driver, ApplicationMenuPageUI.DYNAMIC_APPLICATION_MENU);
        clickToElement(driver, ApplicationMenuPageUI.DYNAMIC_APPLICATION_MENU, application);
    }
}
