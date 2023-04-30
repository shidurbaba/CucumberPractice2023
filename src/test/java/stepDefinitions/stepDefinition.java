package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class stepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) {

    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);

    landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();

    System.out.println(landingPageProductName + " is extracted from Home page");

    }

    @Then("User searched for {string} shortname in offers page to check if product exist with same name")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String ShortName) {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);

        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();


    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, landingPageProductName);
    }


}
