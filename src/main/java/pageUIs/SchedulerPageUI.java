package pageUIs;

public class SchedulerPageUI {
    public static final String NEW_APPOINTMENT_LINK = "xpath=//span[@class='menu_item']/a[contains(@href,'add.csp')]";
    public static final String ADD_APPOINTMENT_BUTTON = "css=#schedule_submit_button a";
    public static final String SUBJECT_APPOINTMENT = "css=input[title='Appointment title']";
    public static final String SUBJECT_APPOINTMENT_DETAIL = "css=#event_list h2";
    public static final String SELECT_ALL_LINK = "id=select_all_selectlist_sUID";
    public static final String REMOVE_BUTTON = "id=btn_rmv_sUID";
    public static final String PRIVATE_RADIO_BUTTON = "xpath=//label[text()='Private']/preceding-sibling::input";
}
