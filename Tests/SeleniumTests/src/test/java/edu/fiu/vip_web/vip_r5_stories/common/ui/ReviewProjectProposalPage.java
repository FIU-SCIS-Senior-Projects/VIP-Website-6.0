package edu.fiu.vip_web.vip_r5_stories.common.ui;

import org.openqa.selenium.By;

/**
 * Created by josep on 5/27/17.
 */
public class ReviewProjectProposalPage {
    public static final By REJECT_PROPOSAL_BUTTON_FIRST = By.xpath("//td[8]/div/button");
    public static final String XPATH_REVIEW_PROJECT_PROPOSAL_DATE_FORMAT = "//table[1]/tbody[1]/tr[%d]/td[1]/input";
    public static final By PROJECT_PROPOSAL_DATE_LABEL = By.xpath("//table[1]/tbody/tr[1]/td[1]/label");
}
