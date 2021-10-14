package cucumber.options;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
//        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
        plugin = { "pretty", "html:target/cucumber.html" },
        monochrome = true
)

public class TestRunner {
}
