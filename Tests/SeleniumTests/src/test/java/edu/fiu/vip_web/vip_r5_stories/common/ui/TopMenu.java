package edu.fiu.vip_web.vip_r5_stories.common.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by josep on 5/26/17.
 */
public class TopMenu {
    public static final By TEXT_PROSPECTIVE_STUDENTS = By.linkText("PROSPECTIVE STUDENTS");

    public static class ProspectiveStudents {
        public static final By TEXT_REVIEW_FACULTY_REGISTRATIONS = By.linkText("REVIEW FACULTY REGISTRATIONS");

        public static void goToReviewFacultyRegistrations(WebDriver driver) {
            new Actions(driver)
                    .moveToElement(driver.findElement(TopMenu.TEXT_PROSPECTIVE_STUDENTS)).click()
                    .moveToElement(driver.findElement(TopMenu.ProspectiveStudents.TEXT_REVIEW_FACULTY_REGISTRATIONS)).click()
                    .build().perform();
        }
    }
}
