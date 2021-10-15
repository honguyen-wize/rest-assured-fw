package cucumber.options;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = { "pretty", "html:target/cucumber.html", "json:target/jsonReports/cucumber-report.json" },
        tags = "@AddPlace or @DeletePlace"
)

public class TestRunner {
}
