package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorPageSignIn {

    public WebDriver driver;
    //Instantiate an object
    public LocatorPageSignIn(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css="input#inputUsername")
    WebElement Username;

    @FindBy(css="input[type='password']")
    WebElement Password;

    @FindBy(css="button[type='submit']")
    WebElement applyPromoBtn;

    

    public void CheckoutItems() throws InterruptedException {
        Username.sendKeys("TestUser1");
        Password.sendKeys("Password123");
        applyPromoBtn.click();
    }
}
