package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        // If your folder is actually named "Features", change it here:
        features = "src/test/resources/login.feature",
        glue = "stepDefinitions",
        plugin = {"pretty"}
)
public class TestRunner {
}
