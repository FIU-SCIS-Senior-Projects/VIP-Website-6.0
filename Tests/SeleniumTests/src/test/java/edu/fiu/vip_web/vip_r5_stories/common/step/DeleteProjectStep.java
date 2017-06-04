/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ProjectDetailsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewProjectProposalPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Dafna
 */
public class DeleteProjectStep extends SeleniumTestStep {

    public DeleteProjectStep(WebDriver driver) {
        super(driver);
    }

    
    @Override
    public void execute() throws Exception
    {
        
    }
    
    public void execute(String projectName) throws Exception {
        
        new ToSpecificProjectStep(getDriver()).execute(projectName);
        
        waitForElement(ProjectDetailsPage.DELETE_BUTTON);
        click(ProjectDetailsPage.DELETE_BUTTON); 
        
        waitForElement(Dialog.CONFIRM_BUTTON); 
        click(Dialog.CONFIRM_BUTTON); 
        waitForElementGone(Dialog.CONFIRM_BUTTON); 
    }

}
