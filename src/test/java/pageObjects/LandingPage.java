package pageObjects;

import org.openqa.selenium.By;
import utils.TestContextStepUp;

public class LandingPage {

    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");

    TestContextStepUp testContextStepUp;
    //Instantiate an object
    public LandingPage(TestContextStepUp contextStepUp)
    {
        this.testContextStepUp = contextStepUp;
    }

    public void searchItem(String name)
    {
        testContextStepUp.driver.findElement(search).sendKeys(name);
    }

    public String getTrimSearchResult() {
        return testContextStepUp.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    }

}
