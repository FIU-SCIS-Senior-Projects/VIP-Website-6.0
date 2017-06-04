// #####################################################################
// #1193 Extend Lock and Unlock Functionality for semester lock
//
// Description:
// As a User I would like to set a Semester to Inactive so that professors 
// can't propose projects for old semesters.
// 
// Acceptance Criteria:
// Terms collection updated
// When a term is locked, any project from that semester is locked
// Projects cannot be proposed for locked semesters
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1193;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import org.openqa.selenium.WebDriver;

public class Card1193Step extends SeleniumTestStep {

    
     public Card1193Step(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
      
    }
    
}
