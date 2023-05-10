package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextStepUp;

public class LandingPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    LandingPage landingPage;
    TestContextStepUp testContextStepUp;
    PageObjectManager pageObjectManager;
    public LandingPageStepDefinition(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
       // testContextStepUp.driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) throws InterruptedException {
        landingPage.searchItem(ShortName);
        Thread.sleep(2000);
        testContextStepUp.landingPageProductName = landingPage.getTrimSearchResult();

        System.out.println(testContextStepUp.landingPageProductName + " is extracted from Home page");

    }



}