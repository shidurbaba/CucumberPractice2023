package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextStepUp;

public class LandingPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    LandingPage landingPage;
    TestContextStepUp testContextStepUp;
    public LandingPageStepDefinition(TestContextStepUp contextStepUp, LandingPage landingPage)
    {
        this.testContextStepUp = contextStepUp;
        this.landingPage = landingPage;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        testContextStepUp.driver = new ChromeDriver();
        testContextStepUp.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) throws InterruptedException {
        landingPage.searchItem(ShortName);
        Thread.sleep(2000);
        testContextStepUp.landingPageProductName = landingPage.getTrimSearchResult();

        System.out.println(testContextStepUp.landingPageProductName + " is extracted from Home page");

    }



}