package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.SchedulerPageUI;

public class SchedulerPageObject extends ApplicationMenuPageObject{
    public SchedulerPageObject(WebDriver driver) {
        super(driver);
    }


    public void clickToNewAppointmentLink() {
        waitForElementClickable(driver, SchedulerPageUI.NEW_APPOINTMENT_LINK);
        clickToElement(driver, SchedulerPageUI.NEW_APPOINTMENT_LINK);
    }

    public void clickToAddButton() {
        waitForElementClickable(driver, SchedulerPageUI.ADD_APPOINTMENT_BUTTON);
        clickToElement(driver, SchedulerPageUI.ADD_APPOINTMENT_BUTTON);
    }

    public void removeUserInAttendeesList() {
        waitForElementClickable(driver, SchedulerPageUI.SELECT_ALL_LINK);
        clickToElement(driver, SchedulerPageUI.SELECT_ALL_LINK);
        waitForElementClickable(driver, SchedulerPageUI.REMOVE_BUTTON);
        clickToElement(driver, SchedulerPageUI.REMOVE_BUTTON);
    }

    public void enterSubjectAppointmentTextbox(String subject) {
        waitForElementVisible(driver, SchedulerPageUI.SUBJECT_APPOINTMENT);
        sendkeyToElement(driver, SchedulerPageUI.SUBJECT_APPOINTMENT, subject);
    }

    public String getSubjectAppointmentDetail() {
        waitForElementVisible(driver, SchedulerPageUI.SUBJECT_APPOINTMENT_DETAIL);
        return getTextElement(driver, SchedulerPageUI.SUBJECT_APPOINTMENT_DETAIL);
    }

    public void selectPrivateRadioButton() {
        waitForElementVisible(driver, SchedulerPageUI.PRIVATE_RADIO_BUTTON);
        checkTheCheckBoxOrRadio(driver, SchedulerPageUI.PRIVATE_RADIO_BUTTON);
    }

    public void clickOnAllDayButton() {
        waitForElementClickable(driver, SchedulerPageUI.ALL_DAY_BUTTON);
        clickToElement(driver, SchedulerPageUI.ALL_DAY_BUTTON);
    }
}
