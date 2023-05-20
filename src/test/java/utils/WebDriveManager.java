package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Properties;

public class WebDriveManager {

    public WebDriver driver;
    public ChromeOptions chromeOptions;

    public Properties properties;

    public PageObjectManager pageObjectManager;
    public  WebDriver WebDriveManager() throws IOException {
      this.pageObjectManager = new PageObjectManager(driver);
      this.properties = pageObjectManager.getProperties();


      if( properties.getProperty("browser").equalsIgnoreCase("chrome")) {
          if (driver == null) {
              this.chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("--incognito");
              chromeOptions.addArguments("--start-maximized");
              chromeOptions.addArguments("--ignore-certificate-errors");
              chromeOptions.addArguments("--disable-gpu");
              //chromeOptions.addArguments("--headless");
              driver = new ChromeDriver(chromeOptions);
          }
      }
         return driver;
    }


}
