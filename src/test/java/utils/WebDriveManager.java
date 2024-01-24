package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.MutableCapabilities;

import java.time.Duration;
import java.util.Properties;

public class WebDriveManager {

    public WebDriver driver;
    private static final Object lock = new Object();

    public WebDriver getDriver(Properties properties) {
        synchronized (lock) {
            if (driver == null) {
                initializeDriver(properties);
            }
        }
        return driver;
    }

    private void initializeDriver(Properties properties) {
        String browser = properties.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("headlessMode"));

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                addCommonOptions(chromeOptions);
                if(isHeadless)
                {
                    chromeOptions.addArguments("--headless");

                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                addCommonOptions(edgeOptions);
                if(isHeadless)
                {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                addCommonOptions(firefoxOptions);
                if(isHeadless)
                {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser [" + browser + "] is not supported.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void addCommonOptions(ChromeOptions options) {
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        // Uncomment the next line if headless mode is desired
        // options.addArguments("--headless");
    }

    private void addCommonOptions(EdgeOptions options) {
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        //options.addArguments("--headless");
    }

    private void addCommonOptions(FirefoxOptions options) {
        options.addArguments("--private");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        // options.addArguments("--disable-popup-blocking");
       //  options.addArguments("--headless");
    }



}
