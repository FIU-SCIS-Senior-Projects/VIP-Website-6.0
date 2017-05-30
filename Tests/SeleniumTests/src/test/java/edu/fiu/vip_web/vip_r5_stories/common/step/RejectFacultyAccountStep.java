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
        boolean dateFound = false;
        int i = 2;
        Calendar date = GregorianCalendar.getInstance();
        By criteria = null;
        do {
            criteria = By.xpath(String.format(ReviewFacultyRegistrationsPage.XPATH_REVIEW_FACULTY_REGISTRATIONS_DATE_FORMAT, i));
            if(isElementPresent(criteria)) {
                String value = getDriver().findElement(criteria).getAttribute("value");
                if (value != null &&
                        value.trim().startsWith(String.format("%d/%d/%d",
                                date.get(Calendar.MONTH) + 1, date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.YEAR)))) {
                    dateFound = true;
                    break;
                } else {
                    i++;
                }
            }
        } while(isElementPresent(criteria) && !dateFound);
        Assert.assertTrue(dateFound);
        click(By.xpath(String.format(ReviewFacultyRegistrationsPage.XPATH_REJECT_REGISTRATION_BUTTON_FORMAT, i)));
        click(Dialog.CONFIRM_BUTTON);
        waitForElementGone(Dialog.CONFIRM_BUTTON);
    }
}
