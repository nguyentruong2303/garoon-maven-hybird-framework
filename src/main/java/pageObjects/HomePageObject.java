package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends ApplicationMenuPageObject {


    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
