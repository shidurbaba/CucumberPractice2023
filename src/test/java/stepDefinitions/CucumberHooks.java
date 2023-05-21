package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.TestContextStepUp;

import java.io.IOException;

public class CucumberHooks {

    public TestContextStepUp testContextStepUp;
    public WebDriver driver;

    public  CucumberHooks ( TestContextStepUp testContextStepUp) throws IOException {
        this.testContextStepUp = testContextStepUp;

    }



    @After
    public void AfterScenario() throws IOException {
        testContextStepUp.webDriveManager.WebDriveManager().quit();
    }
}
