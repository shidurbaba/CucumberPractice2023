package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextStepUp {


    public WebDriver driver;
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;

    public TestContextStepUp()
    {
        pageObjectManager = new PageObjectManager(driver);
    }




}
