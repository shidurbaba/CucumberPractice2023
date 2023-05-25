package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public WebDriver driver;
    //Instantiate an object
    public CheckoutPage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[alt='Cart']")
    WebElement cartBag;

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    WebElement checkoutButton;

    @FindBy(css=".promoBtn")
    WebElement applyPromoBtn;

    @FindBy(xpath = "//button[contains(text(),'Place Order' )]")
    WebElement placeOrderButton;

    public void CheckoutItems()
    {
        cartBag.click();
        checkoutButton.click();
    }

    public Boolean VerifyPromoBtn(){return applyPromoBtn.isDisplayed();}

    public Boolean VerifyPlaceOrderBtn(){return placeOrderButton.isDisplayed();}



}
