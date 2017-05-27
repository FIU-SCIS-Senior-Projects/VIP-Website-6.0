package edu.fiu.vip_web.vip_r5_stories.tests.Card1211;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.AdminLoginStep;
import edu.fiu.vip_web.vip_r5_stories.common.step.LogoffStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by josep on 5/27/17.
 */
public class Card1211Test extends SeleniumTestBase {

    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1211Test() throws Exception {
        executeSteps(Arrays.asList(
                new AdminLoginStep(getDriver()),
                new Card1211Step(getDriver()),
                new LogoffStep(getDriver())
        ));
    }

    @After
    public void teardown() {
        super.teardown();
    }
}
