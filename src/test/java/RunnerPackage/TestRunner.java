package RunnerPackage;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\moses\\IdeaProjects\\CucumberPractice2023\\src\\test\\java\\cucumber\\ExamplesDemoPart1.feature",
        glue = {"stepDefinitions"},
        tags = "not @Sanity",
        dryRun = false
)
public class TestRunner {
}
