package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class OffersPage {

    public WebDriver driver;
    //Instantiate an object
    public OffersPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By searchResult = By.cssSelector("tr td:nth-child(1)");
    private By TopResults = By.linkText("Top Deals");

    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }
    public String extractedSearchResult() {
        return driver.findElement(searchResult).getText();
    }

    public void topResultsClick()
    {
        driver.findElement(TopResults).click();

    }
    public void switchToOfferPage() {
        topResultsClick();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }
}
