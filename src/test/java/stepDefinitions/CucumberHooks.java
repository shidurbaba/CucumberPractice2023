package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
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

   /* @AfterStep
    public void AddScreenShot(){
        System.out.println("screen shot test");
    }*/
 /*   @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) { // or remove this if block if you want to capture screenshots for every step
            // Take the screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Attach it to the report
            try {
                Path screenshotPath = Paths.get("./screenshots", screenshotFile.getName());
                Files.copy(screenshotFile.toPath(), screenshotPath);
                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
   @AfterStep
   public void addScreenshot(Scenario scenario) throws IOException {
       // Take a screenshot for every step (or you can modify it to capture only on failure)
       if(scenario.isFailed())
       {
           final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

           // Attach it to the Cucumber scenario
           scenario.attach(screenshot, "image/png", scenario.getName());

           // Attach it to the Extent Report
           ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("data:image/png;base64," + new String(screenshot));
       }


   }
/*    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Define screenshot path
            String screenshotDir = "test-output/ExtentReport/FailedScenarios";
            String screenshotName = "FAILED_" + scenario.getId() + ".png";
            Path screenshotPath = Paths.get(screenshotDir + screenshotName);

            // Create directories if they don't exist
            if (!Files.exists(screenshotPath.getParent())) {
                Files.createDirectories(screenshotPath.getParent());
            }

            // Take and save the screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile.toPath(), screenshotPath, StandardCopyOption.REPLACE_EXISTING);

            // Attach screenshot to Extent Reports
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath.toString());
        }
    }*/
}
