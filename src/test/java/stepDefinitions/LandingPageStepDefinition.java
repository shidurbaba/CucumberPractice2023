package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextStepUp;

public class LandingPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;

    TestContextStepUp testContextStepUp;
    public LandingPageStepDefinition(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        testContextStepUp.driver = new ChromeDriver();
        testContextStepUp.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) throws InterruptedException {

        testContextStepUp.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);
    Thread.sleep(2000);
        testContextStepUp.landingPageProductName = testContextStepUp.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();

    System.out.println(testContextStepUp.landingPageProductName + " is extracted from Home page");

    }





}
