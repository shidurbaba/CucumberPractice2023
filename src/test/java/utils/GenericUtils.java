package utils;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;
    public WebDriverWait webDriverWait;



    public GenericUtils(WebDriver driver)
    {
        this.driver = driver;

    }
    public void SwitchWindowToChild()
    {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> il = s1.iterator();
        String parentWindow = il.next();
        String childWindow = il.next();
        driver.switchTo().window(childWindow);
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        this.webDriverWait = new WebDriverWait(driver, Duration.ofNanos(timeoutInSeconds));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofNanos(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static JsonPath rawtoJson(String response)
    {
        JsonPath js1 = new JsonPath(response);
        return js1;
    }



}
