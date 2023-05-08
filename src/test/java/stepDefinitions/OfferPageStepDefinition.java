package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestContextStepUp;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    TestContextStepUp testContextStepUp;
    public OfferPageStepDefinition(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
    }
    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String ShortName) throws InterruptedException {
        testContextStepUp.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = testContextStepUp.driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        testContextStepUp.driver.switchTo().window(childWindow);

        testContextStepUp.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);
        Thread.sleep(2000);
        offerPageProductName = testContextStepUp.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();


    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextStepUp.landingPageProductName);
    }


}
