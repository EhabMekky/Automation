package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG-based Cucumber test runner.
 * Features: src/test/resources/feature
 * Glue: cucumber package (where your StepDefinition lives)
 */
@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"cucumber"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
