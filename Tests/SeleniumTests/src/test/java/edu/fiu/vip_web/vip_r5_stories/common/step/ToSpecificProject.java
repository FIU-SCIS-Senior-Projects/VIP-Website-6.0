/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewProjectProposalPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Dafna
 */
public class ToSpecificProject extends SeleniumTestStep {

    public ToSpecificProject(WebDriver driver) {
        super(driver);
    }
    
    @Override
    public void execute() throws Exception {
        
    }
    
    public void execute(String projectName) throws Exception {
        waitForElement(TopMenu.PROJECTS);
        click(TopMenu.PROJECTS); 
    }

    private void findSpecific() throws InterruptedException {
       
        /*
        int index = findTodaysIndexByFormat(ReviewProjectProposalPage.XPATH_REVIEW_PROJECT_PROPOSAL_DATE_FORMAT, 2);
        Assert.assertTrue("Proposal not found", index != -1);
        click(By.xpath(String.format(ReviewProjectProposalPage.XPATH_REJECT_PROPOSAL_BUTTON_FORMAT, index)));
        click(Dialog.CONFIRM_BUTTON);
        waitForElementGone(Dialog.CONFIRM_BUTTON);
*/
    }
}

