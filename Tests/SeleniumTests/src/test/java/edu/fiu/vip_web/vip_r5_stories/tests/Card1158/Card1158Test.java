// #####################################################################
// #1158 Search name in admin panel 
//  
// Description:
// As a user, I would like to search the students in the list of Users 
// available in the admin panel so that it would be feasible for quick 
// navigation.
//
// Acceptance Criteria:
// Admin panel should be open without any errors
// Search box should result in finding the students if they are available 
// in the list
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1158;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Card1158Test extends SeleniumTestBase{
    
     @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1158Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new Card1158Step(getDriver())
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
