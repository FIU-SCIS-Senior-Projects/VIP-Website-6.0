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

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.AdminLoginStep;
import edu.fiu.vip_web.vip_r5_stories.common.step.LogoffStep;
import edu.fiu.vip_web.vip_r5_stories.common.step.ToAdminPanelStep;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dafna
 */

public class Card1193Test extends SeleniumTestBase{
    
        final String PROJ_NAME = "BOLO", 
                 ACTIVE = "Active", 
                 DISABLED = "Disabled"; 
     @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1193Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new AdminLoginStep(getDriver()), 
                new ToAdminPanelStep(getDriver()),
                new Card1193Step(getDriver(), PROJ_NAME, DISABLED),
                new ToAdminPanelStep(getDriver()),
                new Card1193Step(getDriver(), PROJ_NAME, ACTIVE) 
        )); 
        
    }
    
    @After
    public void teardown() throws Exception {
        try {
            toBaseURL(); 
                new LogoffStep(getDriver()).execute();
            
        } finally {
            super.teardown();
        }
    }
}
