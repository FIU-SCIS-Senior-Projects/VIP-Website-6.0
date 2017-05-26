package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.HomePage;
import org.junit.Assert;
import org.openqa.selenium.*;

public class LogoffStep extends SeleniumTestStep {

    public LogoffStep(WebDriver driver) {
        super(driver);
    }

    @Override
    public void execute() throws Exception {
        waitForElement(HomePage.LOGOFF_BUTTON);
        getDriver().findElement(HomePage.LOGOFF_BUTTON).click();
        Assert.assertTrue(isElementPresent(HomePage.LOGIN_BUTTON));
    }
}
