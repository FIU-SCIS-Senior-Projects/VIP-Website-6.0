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
        click(HomePage.LOGOFF_BUTTON);
        waitForElement(HomePage.LOGIN_BUTTON);
    }
}
