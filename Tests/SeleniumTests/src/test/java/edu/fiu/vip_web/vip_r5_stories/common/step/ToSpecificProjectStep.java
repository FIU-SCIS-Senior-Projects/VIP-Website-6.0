/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ProjectDetailsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ProjectsPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ReviewProjectProposalPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.TopMenu;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Dafna
 */
public class ToSpecificProjectStep extends SeleniumTestStep {

    public ToSpecificProjectStep(WebDriver driver) {
        super(driver);
    }
    
    @Override
    public void execute() throws Exception {
        
        execute(""); 
    }
    
    public void execute(String projectName) throws Exception {
        
        waitForElement(TopMenu.PROJECTS);
        click(TopMenu.PROJECTS); 
        findSpecific(projectName); 
    }

    private void findSpecific(String projectName) throws InterruptedException {
       
        String nameFromHeader;
        String failMessage = "Page does not belong to the desired project. "
                + "EXPECTED: %s, ACTUAL: %s"; 
        
        type(ProjectsPage.SEARCH_BOX, projectName);
        List<WebElement> projects = getMultipleElements(ProjectsPage.PROJECT_TITLES, 1);
      
        for (WebElement prLink : projects)
        {
            if (prLink.getText().contains(projectName))
            {
                prLink.click();
                break;
            }
        }
        
        waitForElement(ProjectDetailsPage.PROJECT_NAME_HEADER); 
        nameFromHeader = getDriver().findElement(ProjectDetailsPage.PROJECT_NAME_HEADER).getText();
         
        Assert.assertTrue(String.format(failMessage, projectName, nameFromHeader), nameFromHeader.contains(projectName)); 
        /*
        int index = findTodaysIndexByFormat(ReviewProjectProposalPage.XPATH_REVIEW_PROJECT_PROPOSAL_DATE_FORMAT, 2);
        Assert.assertTrue("Proposal not found", index != -1);
        click(By.xpath(String.format(ReviewProjectProposalPage.XPATH_REJECT_PROPOSAL_BUTTON_FORMAT, index)));
        click(Dialog.CONFIRM_BUTTON);
        waitForElementGone(Dialog.CONFIRM_BUTTON);
*/
    }
}

