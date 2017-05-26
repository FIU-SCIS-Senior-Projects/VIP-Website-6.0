package edu.fiu.vip_web.vip_r5_stories.common.step;

import edu.fiu.vip_web.vip_r5_stories.common.ui.HomePage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.*;

public class AdminLoginStep extends SeleniumTestStep {

  public AdminLoginStep(WebDriver driver) {
    super(driver);
  }

  @Override
  public void execute() throws Exception {
    waitForElement(HomePage.LOGIN_BUTTON);
    getDriver().findElement(HomePage.LOGIN_BUTTON).click();

    waitForElement(LoginPage.EMAIL_TEXTBOX);
    getDriver().findElement(LoginPage.EMAIL_TEXTBOX).clear();
    getDriver().findElement(LoginPage.EMAIL_TEXTBOX).sendKeys(getTestData().getAdminUsername());
    getDriver().findElement(LoginPage.PASSWORD_TEXTBOX).clear();
    getDriver().findElement(LoginPage.PASSWORD_TEXTBOX).sendKeys(getTestData().getAdminPassword());
    getDriver().findElement(LoginPage.LOGIN_BUTTON).click();

    while (getDriver().getCurrentUrl().endsWith("/login")) ;
    Assert.assertTrue(isElementPresent(HomePage.LOGOFF_BUTTON));
  }
}
