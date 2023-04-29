package RunnerPackage;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\Users\\moses\\IdeaProjects\\CucumberPractice2023\\src\\test\\java\\feature\\VegetableCart.feature",
        glue = {"GreenKartStepDefinitions"},
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"},
        monochrome = true,
        dryRun = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
