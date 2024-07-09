package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SchedulerPageObject;
import pageObjects.ServicesPageObject;

public class PageGeneratorManager extends BasePage{
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static ServicesPageObject getServicesPage(WebDriver driver) {
        return new ServicesPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return  new HomePageObject(driver);
    }
    public static SchedulerPageObject getSchedulerPage(WebDriver driver) {
        return new SchedulerPageObject(driver);
    }
}
