package edu.fiu.vip_web.vip_r5_stories.tests.Card1208;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewUserPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by josep on 5/26/17.
 */
public class Card1208Step extends SeleniumTestStep {

    public Card1208Step(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        waitForElement(TopMenu.ProspectiveStudents.REVIEW_STUDENT_APPLICATIONS);
        TopMenu.ProspectiveStudents.goToReviewStudentApplications(getDriver());

        waitForElement(ReviewUserPage.REJECT_FIRST_USER_BUTTON);
        assertDateFound();
    }

    private void assertDateFound() {
        boolean dateFound = false;
        int i = 2;
        By criteria = null;
        do {
            criteria = By.xpath(String.format(ReviewUserPage.XPATH_STUDENT_APPLICATION_DATE_TEXTBOX_FORMAT, i++));
            if(isElementPresent(criteria)) {
                String value = getDriver().findElement(criteria).getAttribute("value");
                if (value != null && !value.trim().equals("")) {
                    dateFound = true;
                }
            }
        } while(isElementPresent(criteria) && !dateFound);
        Assert.assertTrue(dateFound);
    }
}
