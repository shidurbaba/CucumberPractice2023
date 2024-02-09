package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetUp;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CucumberHooks {

    private WebDriver driver;

    public  CucumberHooks ( TestContextSetUp contextStepUp) throws IOException {
        this.driver = contextStepUp.webDriveManager.driver;

    }



    @After
    public void AfterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

   @AfterStep
   public void addScreenshot(Scenario scenario) throws IOException {
       // Take a screenshot for every step (or you can modify it to capture only on failure)
       if(scenario.isFailed())
       {
           File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent,"image/png","image");
       }


   }

}
