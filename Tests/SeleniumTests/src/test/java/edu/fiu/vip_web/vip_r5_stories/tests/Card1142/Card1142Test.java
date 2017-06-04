// #####################################################################
// #1142 Add format to "PROJECT PROPOSAL FORM" 's team description
// 
// Description:
// As a user, I would like to view the description of project in the same format
// as the professor has entered so that it would be easy to understand.
// 
// Acceptance Criteria:
// When a professor enters the description for the project the format should be
// kept same after the proposal.
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1142;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.AdminLoginStep;
import edu.fiu.vip_web.vip_r5_stories.common.step.ToAdminPanelStep;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Card1142Test extends SeleniumTestBase{
    
     @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1142Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new Card1142Step(getDriver())
        )); 
        
    }
    
    @After
    public void teardown() throws Exception {
        try {
            // nothing to tear down 
            
        } finally {
            super.teardown();
        }
    }
    
}