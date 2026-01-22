package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue="Step_Definition",
		//monochrome = true,
		tags="@tag4"
		//strict = true
		//dryRun = false
		)
public class TestRunnerGetNegative {

}
