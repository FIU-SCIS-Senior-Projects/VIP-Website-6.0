package edu.fiu.vip_web.vip_r5_stories.common;

/**
 * Created by josep on 5/26/17.
 */
public class FixedTestDataRepository implements TestDataRepository {

    public String getAdminUsername() {
        return "";
    }

    public String getAdminPassword() {
        return "";
    }

    public String getStudentUsername() {
        return "";
    }

    public String getStudentPassword() {
        return "";
    }

    public String getBaseUrl() {
        return "http://vip-dev.cis.fiu.edu/#/";
    }
}
