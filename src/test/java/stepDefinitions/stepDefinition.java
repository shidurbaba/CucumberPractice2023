package stepDefinitions;

import io.cucumber.java.en.*;

public class stepDefinition {


    @Given("^the user has access to (.+)$")
    public void the_user_has_access_to_url(String url) {
        System.out.println("validated url: " + url);
    }
    @When("^the user enters (.+) and (.+)$")
    public void the_user_enters_and(String username, String password) throws Throwable {
        System.out.println(username);
        System.out.println(password);
    }
    @Then("validate login is successful")
    public void validate_login_is_successful() {
        System.out.println("validated login successfully");
    }



}
