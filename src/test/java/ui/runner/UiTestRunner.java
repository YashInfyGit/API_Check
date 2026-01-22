package ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"ui.steps", "ui.hooks"},
        tags = "@ui",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/ui-cucumber.html",
                "json:target/cucumber-reports/ui-cucumber.json"
        },
        monochrome = true
)
public class UiTestRunner extends AbstractTestNGCucumberTests {
}

