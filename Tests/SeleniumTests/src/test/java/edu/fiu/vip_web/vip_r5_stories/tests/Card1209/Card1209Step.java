package edu.fiu.vip_web.vip_r5_stories.tests.Card1209;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewFacultyRegistrationsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewProjectProposalPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by josep on 5/27/17.
 */
public class Card1209Step extends SeleniumTestStep {

    public Card1209Step(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        TopMenu.Faculty.goToReviewProjectProposals(getDriver());
        Assert.assertTrue(
                getDriver().findElement(ReviewProjectProposalPage.PROJECT_PROPOSAL_DATE_LABEL).getText().equals("Date"));
        assertDateFound();
    }

    private void assertDateFound() {
        boolean dateFound = false;
        int i = 2;
        By criteria = null;
        do {
            criteria = By.xpath(String.format(ReviewProjectProposalPage.XPATH_REVIEW_PROJECT_PROPOSAL_DATE_FORMAT, i++));
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
