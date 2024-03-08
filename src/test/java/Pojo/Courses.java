package Pojo;

import java.util.List;

public class Courses {
    private List<WebAutomation> webAutomation;
    private API api;
    private Mobile mobile;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public API getApi() {
        return api;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public void setApi(API api) {
        this.api = api;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }


}
