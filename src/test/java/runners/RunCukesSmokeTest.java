package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepdefinitions",
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber/smoke/html"})
public class RunCukesSmokeTest {

}
