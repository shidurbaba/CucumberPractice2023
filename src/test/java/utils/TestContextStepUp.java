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
        pageObjectManager = new PageObjectManager(webDriveManager.WebDriveManager());
        utils = new GenericUtils(webDriveManager.WebDriveManager());
        landingPage = pageObjectManager.getLandingPage();
        offersPage = pageObjectManager.getOffersPage();
    }




}
