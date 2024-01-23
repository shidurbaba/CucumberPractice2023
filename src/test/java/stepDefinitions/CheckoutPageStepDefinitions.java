package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.PageObjectManager;
import utils.TestContextSetUp;


import java.io.IOException;

public class CheckoutPageStepDefinitions {

    public WebDriver driver;
    public String landingPageProductName;
    public CheckoutPage checkoutPage;
    LandingPage landingPage;
    TestContextSetUp testContextStepUp;
    PageObjectManager pageObjectManager;
    public CheckoutPageStepDefinitions(TestContextSetUp contextStepUp) throws IOException {
        this.testContextStepUp = contextStepUp;
        //this.checkoutPage = pageObjectManager.getCheckoutPage();
        this.checkoutPage = testContextStepUp.checkoutPage;


    }


    @Then("^User proceeds to Checkout and validate the items in checkout page$")
    public void userProceedsToCheckoutAndValidateTheNameItemsInCheckoutPage() throws InterruptedException {

        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
        //Assertion to extract name from screen and compare with name
    }

    @And("Verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(  checkoutPage.VerifyPlaceOrderBtn());
    }


}