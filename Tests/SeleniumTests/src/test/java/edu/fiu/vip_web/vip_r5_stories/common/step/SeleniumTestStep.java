package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.FixedTestDataRepository;
import edu.fiu.vip_web.vip_r5_stories.common.TestDataRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by josep on 5/26/17.
 */
public abstract class SeleniumTestStep {
    private WebDriver driver;
    private WebDriverWait wait;
    private TestDataRepository testData;

    public SeleniumTestStep(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver can't be null.");
        }
        this.driver = driver;
        testData = new FixedTestDataRepository();
        wait = new WebDriverWait(driver, 10);
    }

    public abstract void execute() throws Exception;

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected  void waitForElement(By by) throws InterruptedException {
        waitForElement(by, 60);
    }
    protected  void waitForElement(By by, int seconds) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= seconds) fail("timeout");
            try {
                if (isElementPresent(by))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }

    protected TestDataRepository getTestData() { return testData; }
    protected WebDriver getDriver() {
        return driver;
    }
    protected WebDriverWait getWait() { return wait; }

    protected void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
