package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageObjectManager {

    public LandingPage landingPage;
    public OffersPage offersPage;
    public WebDriver driver;

    public Properties properties;

    public FileInputStream fileInputStream;
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
    public Properties getProperties() throws IOException {
        this.fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        this.properties = new Properties();
        properties.load(fileInputStream);
        return  properties;
    }

}
