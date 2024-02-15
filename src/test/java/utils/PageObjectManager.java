package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageObjectManager {

    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;

    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public OffersPage getOffersPage() {
        if (offersPage == null) {
            offersPage = new OffersPage(driver);
        }
        return offersPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

}
