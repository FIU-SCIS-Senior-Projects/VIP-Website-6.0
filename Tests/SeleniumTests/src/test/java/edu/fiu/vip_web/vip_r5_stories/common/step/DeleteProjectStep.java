
package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.Dialog;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ProjectDetailsPage;
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
