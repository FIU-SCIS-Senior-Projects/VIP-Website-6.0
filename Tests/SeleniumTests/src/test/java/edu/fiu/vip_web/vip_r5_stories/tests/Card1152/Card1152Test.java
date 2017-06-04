// #####################################################################
// #1152 Mingle Filed and Logo 
//
// Description:
// As a user, I would like a link to my project’s mingle
// 
// Acceptance Criteria:
// In the “Project Proposal Form” a field for entering a Mingle Link exists
// If added, in the project approval page, there will be a social icon link to the project Mingle
// When the icon is clicked, the user will be redirected to the link bound to it.
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1152;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Card1152Test extends SeleniumTestBase{
    
     @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1152Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new Card1152Step(getDriver())
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
