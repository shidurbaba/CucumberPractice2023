package GreenKartStepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefinition {

    public WebDriver driver;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) {

    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);
    String productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    System.out.println(productName + " is extracted from Home page");

    }

    @Then("User searched for same shortname in offers page to check if product exist")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist() {

    }




}
