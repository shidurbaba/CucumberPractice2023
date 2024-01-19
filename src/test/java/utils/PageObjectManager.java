package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageObjectManager {

    private LandingPage landingPage;
    private OffersPage offersPage;
    private CheckoutPage checkoutPage;
    private WebDriver driver;
    private Properties properties;

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

    public Properties getProperties() {
        if (properties == null) {
            String propertiesPath = System.getProperty("user.dir") + "//src//test//resources//global.properties";
            try (FileInputStream fileInputStream = new FileInputStream(propertiesPath)) {
                properties = new Properties();
                properties.load(fileInputStream);
            } catch (IOException e) {
                // Handle exception: log it, throw a custom exception, etc.
            }
        }
        return properties;
    }
}
