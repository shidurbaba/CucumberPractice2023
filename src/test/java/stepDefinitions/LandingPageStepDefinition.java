package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.PageObjectManager;
import utils.TestContextSetUp;


public class LandingPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    LandingPage landingPage;
    TestContextSetUp testContextStepUp;
    PageObjectManager pageObjectManager;
    public LandingPageStepDefinition(TestContextSetUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
        this.landingPage = testContextStepUp.landingPage;

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
      landingPage.getMeGreenKartLandingPage();
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }
    @When("^User searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) throws InterruptedException {
        landingPage.searchItem(ShortName);
        Thread.sleep(2000);
         testContextStepUp.landingPageProductName = landingPage.getTrimSearchResult();

        System.out.println(landingPageProductName + " is extracted from Home page");

    }
    @And("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {

        landingPage.incrementQuantity(Integer.parseInt(quantity));
    }

}