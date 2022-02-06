package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:\\workspace\\BDD_Cucumber\\src\\test\\resources\\Features",
		glue="Step_Definition",		
		tags="@tag3"		
		)
public class TestRunnerPostNegative {

}
