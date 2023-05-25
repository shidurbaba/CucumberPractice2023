package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.PageObjectManager;
import utils.TestContextStepUp;

public class CheckoutPageStepDefinitions {

    public WebDriver driver;
    public String landingPageProductName;
    public CheckoutPage checkoutPage;
    LandingPage landingPage;
    TestContextStepUp testContextStepUp;
    PageObjectManager pageObjectManager;
    public CheckoutPageStepDefinitions(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
        this.checkoutPage = testContextStepUp.pageObjectManager.getCheckoutPage();

    }


    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void userProceedsToCheckoutAndValidateTheNameItemsInCheckoutPage() {
        checkoutPage.CheckoutItems();
        //Assertion to extract name from screen and compare with name
    }

    @And("Verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(  checkoutPage.VerifyPlaceOrderBtn());
    }


}