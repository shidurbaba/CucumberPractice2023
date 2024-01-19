package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetUp;


import java.io.IOException;

public class CucumberHooks {

    public TestContextSetUp testContextStepUp;
    public WebDriver driver;

    public  CucumberHooks ( TestContextSetUp testContextStepUp) throws IOException {
        this.testContextStepUp = testContextStepUp;

    }



    @After
    public void AfterScenario() throws IOException {
        driver.quit();
    }
}
