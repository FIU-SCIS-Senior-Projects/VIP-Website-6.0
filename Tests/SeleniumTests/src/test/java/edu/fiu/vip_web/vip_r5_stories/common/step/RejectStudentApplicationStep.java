package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewUserPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by josep on 5/27/17.
 */
public class RejectStudentApplicationStep extends SeleniumTestStep {

    public RejectStudentApplicationStep(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("reviewuser"));
        click(ReviewUserPage.REJECT_FIRST_USER_BUTTON);
        click(Dialog.CONFIRM_BUTTON);
    }
}
