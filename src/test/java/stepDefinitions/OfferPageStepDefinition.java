package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.OffersPage;
import utils.PageObjectManager;
import utils.TestContextSetUp;


public class OfferPageStepDefinition {


    public String landingPageProductName;
    public String offerPageProductName;

    OffersPage offersPage;

    TestContextSetUp testContextStepUp;

    PageObjectManager pageObjectManager;

    public OfferPageStepDefinition(TestContextSetUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
        this.offersPage = pageObjectManager.getOffersPage();
    }
    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String ShortName) throws InterruptedException {
        offersPage.topResultsClick();
        SwitchToChild();
        offersPage.searchItem(ShortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.extractedSearchResult();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        System.out.println(offerPageProductName + "--vs---" + landingPageProductName);
        Assert.assertEquals(offerPageProductName, landingPageProductName);
        //testContextStepUp.driver.quit();
    }

    public void SwitchToChild()
    {
        testContextStepUp.utils.SwitchWindowToChild();
    }


}
