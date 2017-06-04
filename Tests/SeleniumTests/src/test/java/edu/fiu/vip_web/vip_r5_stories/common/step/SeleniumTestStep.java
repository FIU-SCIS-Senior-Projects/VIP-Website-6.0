package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.FixedTestDataRepository;
import edu.fiu.vip_web.vip_r5_stories.common.TestDataRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by josep on 5/26/17.
 */
public abstract class SeleniumTestStep {
    private WebDriver driver;
    private WebDriverWait wait;
    private TestDataRepository testData;
    private static int TIMEOUT = 30;

    protected static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss a";

    public SeleniumTestStep(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver can't be null.");
        }
        this.driver = driver;
        testData = new FixedTestDataRepository();
        wait = new WebDriverWait(driver, TIMEOUT);
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
        waitForElement(by, TIMEOUT);
    }
    protected  void waitForElement(By by, int seconds) throws InterruptedException {
        wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(by));
        Thread.sleep(500);
    }

    protected void waitForElementGone(By element) throws InterruptedException {
        waitForElementGone(element, TIMEOUT);
    }
    protected void waitForElementGone(By element, int seconds) throws InterruptedException {
        wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(element));
        Thread.sleep(500);
    }
    protected void waitForUrlToBe(String url) throws InterruptedException {
        waitForUrlToBe(url, TIMEOUT);
    }
    protected void waitForUrlToBe(String url, int seconds) throws InterruptedException {
        wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.urlToBe(url));
        Thread.sleep(500);
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

    protected boolean checkDateFound(String format, int startingIndex, Function<WebElement, String> getDateValue) {
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        boolean dateFound = false;
        int i = startingIndex;
        By criteria = null;
        do {
            criteria = By.xpath(String.format(format, i++));
            if(isElementPresent(criteria)) {
                String text = getDateValue.apply(getDriver().findElement(criteria));
                try {
                    if (text != null) {
                        formatter.parse(text);
                        dateFound = true;
                    }
                } catch(ParseException e) { }
            }
        } while(isElementPresent(criteria) && !dateFound);
        return dateFound;
    }

    protected int findTodaysIndexByFormat(String xpathFormat, int startingIndex) {
        boolean dateFound = false;
        int i = startingIndex;
        Calendar date = GregorianCalendar.getInstance();
        By criteria = null;
        do {
            criteria = By.xpath(String.format(xpathFormat, i));
            if(isElementPresent(criteria)) {
                String value = getDriver().findElement(criteria).getAttribute("value");
                if (value != null &&
                        value.trim().startsWith(String.format("%d/%d/%d",
                                date.get(Calendar.MONTH) + 1, date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.YEAR)))) {
                    dateFound = true;
                    break;
                } else {
                    i++;
                }
            }
        } while(isElementPresent(criteria) && !dateFound);
        return dateFound ? i : -1;
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
