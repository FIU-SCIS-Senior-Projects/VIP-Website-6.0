package edu.fiu.vip_web.vip_r5_stories.tests.Card1207;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewFacultyRegistrationsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.*;
import org.openqa.selenium.*;

public class Card1207Step extends SeleniumTestStep {

  public Card1207Step(WebDriver driver) {
    super(driver);
  }

  @Override
  public void execute() throws Exception {
    waitForElement(By.linkText(TopMenu.TEXT_PROSPECTIVE_STUDENTS));
    TopMenu.ProspectiveStudents.goToReviewFacultyRegistrations(getDriver());
    waitForElement(By.xpath(ReviewFacultyRegistrationsPage.XPATH_APPROVE_REGISTRATION_BUTTON_FIRST));
    assertDateFound();
  }

  private void assertDateFound() {
        boolean dateFound = false;
        int i = 2;
        By criteria = null;
        do {
            criteria = By.xpath(String.format(ReviewFacultyRegistrationsPage.XPATH_REVIEW_FACULTY_REGIISTRATIONS_DATE_FORMAT, i++));
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
