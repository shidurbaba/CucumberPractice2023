package RunnerPackage;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        },
        monochrome = true,
        dryRun = false
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider (parallel=true    )
    public Object [][] scenarios()
    {
        return super.scenarios();
    }

}
