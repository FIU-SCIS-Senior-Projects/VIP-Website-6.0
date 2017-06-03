package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewFacultyRegistrationsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by josep on 5/29/17.
 */
public class RejectFacultyAccountStep extends SeleniumTestStep {

    public RejectFacultyAccountStep(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        waitForElement(TopMenu.PROSPECTIVE_STUDENTS_MENU);
        TopMenu.ProspectiveStudents.goToReviewFacultyRegistrations(getDriver());
        findAndReject();
    }

    private void findAndReject() throws InterruptedException {
        int index = findTodaysIndexByFormat(ReviewFacultyRegistrationsPage.XPATH_REVIEW_FACULTY_REGISTRATIONS_DATE_FORMAT, 2);
        Assert.assertTrue(index != -1);
        click(By.xpath(String.format(ReviewFacultyRegistrationsPage.XPATH_REJECT_REGISTRATION_BUTTON_FORMAT, index)));
        click(Dialog.CONFIRM_BUTTON);
        waitForElementGone(Dialog.CONFIRM_BUTTON);
    }
}
