package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestContextSetUp;

public class LandingPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");

    @FindBy (css = ".increment")
    WebElement increment;

    @FindBy (css = ".product-action")
    WebElement addToCart;

    public WebDriver driver;
    private TestContextSetUp testContextSetUp;


    //Instantiate an object
   public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        this.testContextSetUp = new TestContextSetUp();
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
        driver.get(testContextSetUp.properties.getProperty("url"));
    }

    public String getTitleLandingPage()
    {
        return driver.getTitle();
    }

 public void incrementQuantity(int quantity) {
     for (int i = 0; i < quantity - 1; i++) {
         increment.click();
     }
 }

    public void addToCartMethod()
    {
        addToCart.click();
    }

}
