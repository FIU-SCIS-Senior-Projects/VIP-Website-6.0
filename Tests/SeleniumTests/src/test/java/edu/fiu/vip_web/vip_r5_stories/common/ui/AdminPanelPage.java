package edu.fiu.vip_web.vip_r5_stories.common.ui;

import org.openqa.selenium.By;

/**
 * Created by josep on 5/27/17.
 */
public class AdminPanelPage {
    public static final By DOWNLOAD_EXCEL_BUTTON = By.xpath("//li[3]/button");

    public static final By GENDER_FILTER_TEXTBOX = By.xpath("(//input[@type='text'])[8]");
    public static final By EMAIL_FILTER_TEXTBOX = By.xpath("(//input[@type='text'])[3]");

    public static final String XPATH_FIRST_NAME_FIELD_FORMAT = "//table[1]/tbody/tr[%d]/td[1]";

    public static final String XPATH_PROJECT_APPLICATION_DATE_FIELD_FORMAT = "//tbody/tr[%d]/td[14]";
    public static final String XPATH_USER_REGISTRATION_DATE_FIELD_FORMAT = "//tbody/tr[%d]/td[15]";
    public static final String XPATH_FIRST_LOGIN_DATE_FIELD_FORMAT = "//tbody/tr[%d]/td[16]";

    public static final By FIRST_LOGIN_DATE_FIELD_FIRST = By.xpath("//tbody/tr[1]/td[16]");

    public static final By PROJECT_APPLICATION_DATE_LABEL = By.xpath("//td[14]");
    public static final By USER_REGISTRATION_DATE_LABEL = By.xpath("//td[15]");
    public static final By FIRST_LOGIN_DATE_LABEL = By.xpath("//td[16]");
}
