package edu.fiu.vip_web.vip_r5_stories.tests.Card1214;

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
public class Card1214Test extends SeleniumTestBase {

    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void card1214Test() throws Exception {
        executeSteps(Arrays.asList(
                new AdminLoginStep(getDriver()),
                new Card1214Step(getDriver()),
                new LogoffStep(getDriver())
        ));
    }

    @After
    public void teardown() throws Exception {
        super.teardown();
    }
}
