package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriveManager {

    public WebDriver driver;

    public  WebDriver WebDriveManager()
    {
         return driver = new ChromeDriver();
    }
}
