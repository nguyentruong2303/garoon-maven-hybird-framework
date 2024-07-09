package com.garoon.scheduler;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SchedulerPageObject;
import pageObjects.ServicesPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class AddRegularAppointment extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    SchedulerPageObject schedulerPage;
    LoginPageObject loginPage;
    ServicesPageObject servicesPage;
    private String browserName;
    private String subject, username, password;

    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        this.browserName = browserName;
        username = GlobalContants.USERNAME;
        password = GlobalContants.PASSWORD;
        driver = getBrowserDriverWithUrl(browserName, GlobalContants.URL_CLOUD);

        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTextbox(username);
        loginPage.enterToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        servicesPage = PageGeneratorManager.getServicesPage(driver);
        Assert.assertTrue(servicesPage.isGaroonServicesDisplayed());

        servicesPage.clickToGaroonServices();
        subject = "Appointment 1";
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.openDynamicApplicationMenu("Scheduler");
        schedulerPage = PageGeneratorManager.getSchedulerPage(driver);
        schedulerPage.clickToNewAppointmentLink();
    }

    @Test
    public void TC_01_Add_Appointment_With_StartDate_GREATER_THAN_EndDate(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Appointment with start date greater than end date");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Select Start Day and End Day");
        schedulerPage.selectDateTimeDropDown("end_day","1(Mon)");

        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 02: Click to Add button");
        schedulerPage.clickToAddButton();
        Assert.assertTrue(schedulerPage.isDialogErrorMessageDisplayed("GRN_SCHD_13006"));
        schedulerPage.refreshPageCurrent(driver);
    }

    @Test
    public void TC_02_Add_Appointment_With_StartTime_GREATER_THAN_EndTime(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Appointment with start time greater than end time");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Select Start time and End time");
        schedulerPage.selectDateTimeDropDown("start_hour","10");
        schedulerPage.selectDateTimeDropDown("end_hour","9");

        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 02: Click to Add button");
        schedulerPage.clickToAddButton();
        Assert.assertTrue(schedulerPage.isDialogErrorMessageDisplayed("GRN_SCHD_13012"));
        schedulerPage.refreshPageCurrent(driver);
    }

    @Test
    public void TC_03_Add_Appointment_With_No_Attendees(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Appointment with no attendees");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Remove all user in attendees");
        schedulerPage.removeUserInAttendeesList();

        schedulerPage.clickToAddButton();
        Assert.assertTrue(schedulerPage.isDialogErrorMessageDisplayed("GRN_SCHD_13021"));
        schedulerPage.refreshPageCurrent(driver);
    }

    @Test
    public void TC_04_Add_Appointment_With_No_StartEndTime(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Appointment with start and ent time");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Enter subject appointment");
        schedulerPage.enterSubjectAppointmentTextbox(subject);
        schedulerPage.clickToAddButton();

        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 02: Verify subject appointment");
        Assert.assertEquals(schedulerPage.getSubjectAppointmentDetail(),subject);
        schedulerPage.openDynamicApplicationMenu("Scheduler");
        schedulerPage.clickToNewAppointmentLink();
    }

    @Test
    public void TC_05_Add_Appointment_With_No_Subject(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Appointment with no subject appointment");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Enter subject appointment");
        schedulerPage.selectDateTimeDropDown("start_hour","10");
        schedulerPage.clickToAddButton();

        Assert.assertEquals(schedulerPage.getSubjectAppointmentDetail(),"--");
        schedulerPage.openDynamicApplicationMenu("Scheduler");
        schedulerPage.clickToNewAppointmentLink();
    }

    @Test
    public void TC_06_Add_Private_Appointment(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Private appointment");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Select date and time");
        schedulerPage.selectDateTimeDropDown("start_hour","11");
        schedulerPage.enterSubjectAppointmentTextbox(subject);

        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 02: Select visibility: Private");
        schedulerPage.selectPrivateRadioButton();
        schedulerPage.clickToAddButton();
        Assert.assertEquals(schedulerPage.getSubjectAppointmentDetail(),subject+" (Private)");
        schedulerPage.openDynamicApplicationMenu("Scheduler");
        schedulerPage.clickToNewAppointmentLink();
    }

    @Test
    public void TC_06_Add_Public_Appointment(Method method) {
        ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add public appointment");
        ExtentTestManager.getTest().log(Status.INFO, "Add Appointment - Step 01: Select date and time");
        schedulerPage.selectDateTimeDropDown("start_hour","12");
        schedulerPage.enterSubjectAppointmentTextbox(subject);
        schedulerPage.clickToAddButton();
        Assert.assertEquals(schedulerPage.getSubjectAppointmentDetail(),subject);
    }


    @AfterClass
    public void afterClass() {
        quitBrowser();
    }
}
