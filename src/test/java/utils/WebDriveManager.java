package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriveManager {

    public WebDriver driver;
    public ChromeOptions chromeOptions;

    public  WebDriver WebDriveManager()
    {
         if(driver == null)
         {
             this.chromeOptions = new ChromeOptions();
             chromeOptions.addArguments("--incognito");
             chromeOptions.addArguments("--start-maximized");
             chromeOptions.addArguments("--ignore-certificate-errors");
             chromeOptions.addArguments("--disable-gpu");
             //chromeOptions.addArguments("--headless");
             driver = new ChromeDriver(chromeOptions);
         }
         return driver;
    }
}
