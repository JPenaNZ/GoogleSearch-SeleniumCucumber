package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//main//resources//Features",
        glue = "stepDefinitions",
        tags = { "@SearchGoogle" },
        plugin = { "pretty", "json:target/cucumber/data.json" }
)

public class TestRunner {

}
