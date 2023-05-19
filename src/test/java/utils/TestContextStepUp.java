package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

public class TestContextStepUp {


    public WebDriver driver;
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;

    public WebDriveManager webDriveManager;

    public GenericUtils utils;

    public LandingPage landingPage;

    public OffersPage offersPage;

    public TestContextStepUp()
    {
        webDriveManager = new WebDriveManager();
        this.driver = webDriveManager.WebDriveManager();
        pageObjectManager = new PageObjectManager(driver);
        utils = new GenericUtils(driver);
        landingPage = pageObjectManager.getLandingPage();
        offersPage = pageObjectManager.getOffersPage();
    }




}
