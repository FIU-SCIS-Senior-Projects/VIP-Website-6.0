package edu.fiu.vip_web.vip_r5_stories.common.step;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import edu.fiu.vip_web.vip_r5_stories.common.ui.ApplyForProjectPage;
import edu.fiu.vip_web.vip_r5_stories.common.ui.HomePage;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplyForProjectStep extends SeleniumTestStep {

  public ApplyForProjectStep(WebDriver driver) {
    super(driver);
  }

  @Override
  public void execute() throws Exception {
    getDriver().findElement(HomePage.APPLY_FOR_PROJECT).click();

    String project = select(ApplyForProjectPage.PROJECT_SELECT, ApplyForProjectPage.PROJECT_SELECT_SECOND_OPTION);
    String semester = select(ApplyForProjectPage.SEMESTER_SELECT, ApplyForProjectPage.SEMESTER_SELECT_SECOND_OPTION);
    String rank = select(ApplyForProjectPage.RANK_SELECT, ApplyForProjectPage.RANK_SELECT_SECOND_OPTION);

    getDriver().findElement(ApplyForProjectPage.PID_TEXTBOX).clear();
    getDriver().findElement(ApplyForProjectPage.PID_TEXTBOX).sendKeys("5325585");

    String gender = select(ApplyForProjectPage.GENDER_SELECT, ApplyForProjectPage.GENDER_SELECT_SECOND_OPTION);
    String reason = select(ApplyForProjectPage.REASON_SELECT, ApplyForProjectPage.REASON_SELECT_THIRD_OPTION);
    String college = select(ApplyForProjectPage.COLLEGE_SELECT, ApplyForProjectPage.COLLEGE_SELECT_SECOND_OPTION);
    String department = select(ApplyForProjectPage.DEPARTMENT_SELECT, ApplyForProjectPage.DEPARTMENT_SELECT_SECOND_OPTION);

    waitForElement(ApplyForProjectPage.EXPERIENCE_TEXTBOX);
    getDriver().findElement(ApplyForProjectPage.EXPERIENCE_TEXTBOX).clear();
    getDriver().findElement(ApplyForProjectPage.EXPERIENCE_TEXTBOX).sendKeys("absolutely none");

    getDriver().findElement(ApplyForProjectPage.SUBMIT_BUTTON).click();
    waitForElement(ApplyForProjectPage.SUBMIT_CONFIRM_BUTTON);
    getDriver().findElement(ApplyForProjectPage.SUBMIT_CONFIRM_BUTTON).click();
  }
}
