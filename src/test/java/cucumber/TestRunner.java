package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG-based Cucumber test runner with Allure integration.
 * Features: src/test/resources/feature
 * Glue: cucumber package (where your StepDefinition lives)
 */
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Cucumber plugin
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}