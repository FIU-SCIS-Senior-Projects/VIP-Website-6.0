package edu.fiu.vip_web.vip_r5_stories.common;

import edu.fiu.vip_web.vip_r5_stories.common.step.SeleniumTestStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by josep on 5/26/17.
 */
public class SeleniumTestBase {
    private WebDriver driver;
    private TestDataRepository testData;

    public void setup() {
        driver = new FirefoxDriver();
        testData = new FixedTestDataRepository();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void executeSteps(List<SeleniumTestStep> testSteps) throws Exception {
        if (testSteps == null || testSteps.size() == 0) {
            throw new IllegalArgumentException("Every selenium tests has to have at least one step.");
        }

        driver.get(testData.getBaseUrl());
        for (SeleniumTestStep step : testSteps) {
            step.execute();
        }
    }

    public WebDriver getDriver() { return driver; }

    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
