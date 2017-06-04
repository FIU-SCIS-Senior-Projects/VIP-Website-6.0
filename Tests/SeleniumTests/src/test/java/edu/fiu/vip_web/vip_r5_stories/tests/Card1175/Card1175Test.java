/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fiu.vip_web.vip_r5_stories.tests.Card1175;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dafna
 */
public class Card1175Test extends SeleniumTestBase{
    
     @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1175Test() throws Exception {
        
        executeSteps(Arrays.asList(
                new Card1175Step(getDriver())
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
    