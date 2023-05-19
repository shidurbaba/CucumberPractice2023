package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
