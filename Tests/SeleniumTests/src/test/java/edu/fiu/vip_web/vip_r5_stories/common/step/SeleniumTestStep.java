package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.FixedTestDataRepository;
import edu.fiu.vip_web.vip_r5_stories.common.TestDataRepository;
import edu.fiu.vip_web.vip_r5_stories.common.ui.ApplyForProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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

    protected void waitForElementGone(By element) throws InterruptedException {
        waitForElementGone(element, 60);
    }
    protected void waitForElementGone(By element, int seconds) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= seconds) fail("timeout");
            try {
                if (!isElementPresent(element))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }
    protected void waitForUrlToBe(String url) throws InterruptedException {
        waitForUrlToBe(url, 30);
    }
    protected void waitForUrlToBe(String url, int seconds) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= seconds) fail("timeout");
            try {
                if (driver.getCurrentUrl().equals(url))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }

    /**
     *
     * @param selectBox
     * @param optionToSelect
     * @return The text of the object selected
     */
    protected String select(By selectBox, By optionToSelect) throws InterruptedException {
        waitForElement(optionToSelect);
        String selected = driver.findElement(optionToSelect).getText();
        new Select(driver.findElement(selectBox))
                .selectByVisibleText(selected);
        return selected;
    }

    protected void click(By element) throws InterruptedException {
        waitForElement(element);
        driver.findElement(element).click();
    }

    protected void type(By textBox, String text) throws InterruptedException {
        waitForElement(textBox);
        driver.findElement(textBox).clear();
        driver.findElement(textBox).sendKeys(text);
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
