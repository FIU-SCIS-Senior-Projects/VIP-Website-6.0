
// #####################################################################
// #1101 Add lock and unlock for projects in the teams page 
// 
//  Description:
//  As a PI of the website I would like to be able to:
//  - lock&unlock the project for now(so nobody can apply),
//  - Move the fall semester projects to the fall folder and 
//  - when new faculties apply for a project they can’t apply 
// for the fall any more and their new proposed projects goes to the spring 
// folder
// 
//  Acceptance Criteria:
//  Archives should be still available with a link or logo from new similar 
//  projects (PI add them manually like GitHub or Mingle link)
//  if it’s possible lock should be one for whole semester. and another way for
//  a specific project.
//  Pi must be enable to set and change
//  taking care of teams page application form
//  taking care of join buttons in the team page
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1101;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import edu.fiu.vip_web.vip_r5_stories.common.ui.AdminPanelPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Dafna
 */
public class Card1101Step extends SeleniumTestStep {
    
     public Card1101Step(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
      
        select(AdminPanelPage.LOCK_SEM_SEMESTER_COMBOBOX, "Summer 2017"); 
        select(AdminPanelPage.LOCK_SEM_STATUS_COMBOBOX, "Active"); 
        Thread.sleep(5000);
    }
    
}
