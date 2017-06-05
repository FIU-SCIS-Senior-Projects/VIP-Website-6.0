
// #####################################################################
// #1195 Add a search Box in VIP projects page
//
// Description:
// As a user I would like to have a Search box which would let me search for
// the projects easily.
//
// Acceptance Criteria:
// When any word is entered the respective project should be displayed.
// #####################################################################

package edu.fiu.vip_web.vip_r5_stories.tests.Card1144;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class Card1144Test extends SeleniumTestBase{
    
    private final String SEARCH_TERM = "Test";
    
    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1144Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new Card1144Step(getDriver(), SEARCH_TERM)
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
    
