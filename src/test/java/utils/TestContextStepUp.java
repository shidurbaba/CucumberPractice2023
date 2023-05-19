package utils;

import org.openqa.selenium.WebDriver;

public class TestContextStepUp {


    public WebDriver driver;
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;

    public WebDriveManager webDriveManager;

    public TestContextStepUp()
    {
        webDriveManager = new WebDriveManager();
        pageObjectManager = new PageObjectManager(webDriveManager.WebDriveManager());
    }




}
