package RunnerPackage;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "C:\\Users\\moses\\IdeaProjects\\CucumberPractice2023\\src\\test\\java\\feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
        tags = "@Checkout",
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider (parallel=true)
    public Object [][] scenarios()
    {
        return super.scenarios();
    }

}
