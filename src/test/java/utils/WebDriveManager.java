package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriveManager {

    public WebDriver driver;

    public  WebDriver WebDriveManager()
    {
         if(driver == null)
         {
             driver = new ChromeDriver();
         }
         return driver;
    }
}
