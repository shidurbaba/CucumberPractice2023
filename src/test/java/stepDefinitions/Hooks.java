//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import utils.TestContextSetUp;
//
//public class Hooks {
//
//    TestContextSetUp testContextSetUp;
//
//    public Hooks (TestContextSetUp testContextSetUp)
//    {
//        this.testContextSetUp = testContextSetUp;
//    }
//
//
//    @After
//    public void afterScenario()
//    {
//        testContextSetUp.webDriveManager.driver.quit();
//    }
//
//    @AfterStep
//    public void addScreenshot()
//    {
//        System.out.println("Screenshot test");
//    }
//}
