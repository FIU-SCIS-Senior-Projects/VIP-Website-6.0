package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewProjectProposalPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by josep on 5/27/17.
 */
public class RejectProjectProposalStep extends SeleniumTestStep {

    public RejectProjectProposalStep(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        if (!getDriver().getCurrentUrl().toLowerCase().endsWith("reviewproject")) {
            TopMenu.Faculty.goToReviewProjectProposals(getDriver());
        }
        click(ReviewProjectProposalPage.REJECT_PROPOSAL_BUTTON_FIRST);
        click(Dialog.CONFIRM_BUTTON);
        waitForElementGone(Dialog.CONFIRM_BUTTON);
    }
}
