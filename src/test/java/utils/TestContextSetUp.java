package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestContextSetUp {

    private WebDriver driver;
    public WebDriveManager webDriveManager;
    public PageObjectManager pageObjectManager;
    public GenericUtils utils;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public Properties properties;

    public TestContextSetUp() {
        // Initialize properties
        properties = loadProperties();

        // Rest of the setup
        webDriveManager = new WebDriveManager();
        driver = webDriveManager.getDriver(properties);
        pageObjectManager = new PageObjectManager(driver);
        utils = new GenericUtils(driver);
        landingPage = pageObjectManager.getLandingPage();
        offersPage = pageObjectManager.getOffersPage();
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        String propertiesPath = System.getProperty("user.dir") + "/src/test/resources/global.properties";
        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        return properties;
    }
}
