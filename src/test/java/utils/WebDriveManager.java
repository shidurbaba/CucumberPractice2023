package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Properties;

public class WebDriveManager {

    public WebDriver driver;
    public ChromeOptions chromeOptions;

    public EdgeOptions edgeOptions;

    public FirefoxOptions firefoxOptions;

    public Properties properties;

    public PageObjectManager pageObjectManager;
    public  WebDriver WebDriveManager() throws IOException {
      this.pageObjectManager = new PageObjectManager(driver);
      this.properties = pageObjectManager.getProperties();

    switch (properties.getProperty("browser"))
    {
        case "chrome":
            if (driver == null) {
                this.chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--disable-gpu");
                //chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            }
            break;
        case "edge":
            if (driver == null) {
                this.edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--incognito");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--ignore-certificate-errors");
                edgeOptions.addArguments("--disable-gpu");
                //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            }
            break;
        case "firefox":
            if (driver == null) {
                this.firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--private");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--ignore-certificate-errors");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--disable-popup-blocking");
                //edgeOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            }
            break;

    }
         return driver;
    }


}
