package pojo;



import java.util.List;

public class Courses {

    //Since this is a complex, the return types should be List because WebAutomation, Api, Mobile returns you a list of arrary.
    private List<WebAutomation> webAutomation;
    private List<Api> api;
    private List<Mobile> mobile;
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }
    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }
    public List<Api> getApi() {
        return api;
    }
    public void setApi(List<Api> api) {
        this.api = api;
    }
    public List<Mobile> getMobile() {
        return mobile;
    }
    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }


}
