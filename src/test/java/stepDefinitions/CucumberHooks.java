//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import org.openqa.selenium.WebDriver;
//import utils.TestContextSetUp;
//
//
//import java.io.IOException;
//
//public class CucumberHooks {
//
//    private WebDriver driver;
//
//    public  CucumberHooks ( TestContextSetUp contextStepUp) throws IOException {
//        this.driver = contextStepUp.webDriveManager.driver;
//
//    }
//
//
//
//    @After
//    public void AfterScenario() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @AfterStep
//    public void AddScreenShot(){
//        System.out.println("screen shot test");
//    }
//}
