package edu.fiu.vip_web.vip_r5_stories.common;

/**
 * Created by josep on 5/26/17.
 */
public class FixedTestDataRepository implements TestDataRepository {

    public String getAdminUsername() {
        return "sadjadi@cs.fiu.edu";
    }

    public String getAdminPassword() {
        return "Research123!";
    }

    public String getStudentUsername() {
        return "jponc021@fiu.edu";
    }

    public String getStudentPassword() {
        return "66A29f149191";
    }

    public String getBaseUrl() {
        return "http://vip-dev.cis.fiu.edu/#/";
    }
}
