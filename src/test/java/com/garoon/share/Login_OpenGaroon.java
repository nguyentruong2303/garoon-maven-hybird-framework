package com.garoon.share;

import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;
import pageObjects.ServicesPageObject;

public class Login_OpenGaroon extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    ServicesPageObject servicesPage;
    private String username, password;
    private String browserName;

    public void beforeTest(String browserName) {
        this.browserName = browserName;
        driver = getBrowserDriverWithUrl(browserName,GlobalContants.URL_CLOUD);
        username = GlobalContants.USERNAME;
        password = GlobalContants.PASSWORD;
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTextbox(username);
        loginPage.enterToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        servicesPage = PageGeneratorManager.getServicesPage(driver);
        Assert.assertTrue(servicesPage.isGaroonServicesDisplayed());

        servicesPage.clickToGaroonServices();

        quitBrowser();

    }

}
