package stepDefinitions;

import io.cucumber.java.en.*;

public class stepDefinition {

    @Given("validate the browser")
    public void validate_the_browser() {
        System.out.println("browser validated first");
    }
    @When("browser is triggered")
    public void browser_is_triggered() {
        System.out.println("Browser triggered second");
    }
    @Then("check if browser is started")
    public void check_if_browser_is_started() {
        System.out.println("Browser started last");
    }

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
