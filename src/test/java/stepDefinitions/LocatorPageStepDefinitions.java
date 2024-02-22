package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LocatorPageSignIn;
import utils.TestContextSetUp;

public class LocatorPageStepDefinitions {

    private TestContextSetUp testContextSetUp;
    LocatorPageSignIn locatorPageSignIn;

    public LocatorPageStepDefinitions(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp = testContextSetUp;
        this.locatorPageSignIn = testContextSetUp.pageObjectManager.getLocatorPageSignIn();
    }

    @Given("the user is on locator practice url")
    public void theUserIsOnLocatorPracticeUrl() {

    }

    @When("the user enters {string} and {string} and clicks on submit button")
    public void theUserEntersAndAndClicksOnSubmitButton(String arg0, String arg1) {

    }
}
