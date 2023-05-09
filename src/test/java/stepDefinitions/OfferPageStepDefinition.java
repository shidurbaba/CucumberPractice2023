package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextStepUp;

public class OfferPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    OffersPage offersPage;

    TestContextStepUp testContextStepUp;

    PageObjectManager pageObjectManager;

    public OfferPageStepDefinition(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
    }
    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String ShortName) throws InterruptedException {
        offersPage.switchToOfferPage();
        offersPage.searchItem(ShortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.extractedSearchResult();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextStepUp.landingPageProductName);
    }


}
