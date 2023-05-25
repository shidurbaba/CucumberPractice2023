package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");

    @FindBy (css = ".increment")
    WebElement addToCart;

    public WebDriver driver;


    //Instantiate an object
   public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getTrimSearchResult() {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void getMeGreenKartLandingPage ()
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    public String getTitleLandingPage()
    {
        return driver.getTitle();
    }

}
