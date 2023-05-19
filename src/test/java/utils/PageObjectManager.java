package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

public class PageObjectManager {

    public LandingPage landingPage;
    public OffersPage offersPage;
    public WebDriver driver;
    public PageObjectManager (WebDriver driver)
    {
        this.driver = driver;
    }

    public LandingPage getLandingPage()
    {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPage()
    {
        offersPage = new OffersPage(driver);
        return offersPage;
    }

}
