package edu.fiu.vip_web.vip_r5_stories.tests.Card1208;

import edu.fiu.vip_web.vip_r5_stories.common.SeleniumTestBase;
import edu.fiu.vip_web.vip_r5_stories.common.step.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by josep on 5/26/17.
 */
public class Card1208Test extends SeleniumTestBase {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void card1208Test() throws Exception {
        executeSteps(Arrays.asList(
                new StudentLoginStep(getDriver()),
                new ApplyForProjectStep(getDriver()),
                new LogoffStep(getDriver()),
                new AdminLoginStep(getDriver()),
                new Card1208Step(getDriver())
        ));
    }

    @After
    public void teardown() throws Exception {
        try {
            executeSteps(Arrays.asList(
                    new RejectStudentApplicationStep(getDriver()),
                    new LogoffStep(getDriver())
            ));
        } finally {
            super.teardown();
        }
    }
}
