package pageObjects;

import org.openqa.selenium.By;
import utils.TestContextStepUp;

import java.util.Iterator;
import java.util.Set;

public class OffersPage {

    TestContextStepUp testContextStepUp;
    //Instantiate an object
    public OffersPage(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
    }

    By search = By.xpath("//input[@type='search']");
    By searchResult = By.cssSelector("tr td:nth-child(1)");

    By TopResults = By.linkText("Top Deals");

    public void searchItem(String name)
    {
        testContextStepUp.driver.findElement(search).sendKeys(name);
    }
    public String extractedSearchResult() {
        return testContextStepUp.driver.findElement(searchResult).getText();
    }

    public void topResultsClick()
    {
        testContextStepUp.driver.findElement(TopResults).click();

    }
    public void switchToOfferPage() {
        topResultsClick();
        Set<String> windows = testContextStepUp.driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        testContextStepUp.driver.switchTo().window(childWindow);
    }
}
