package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");

    public WebDriver driver;


    //Instantiate an object
   public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getTrimSearchResult() {
        return driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    }

}
