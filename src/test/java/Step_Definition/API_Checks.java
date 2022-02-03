package Step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_Checks {
	@Given("API for Foreign Exchange")
	public void api_for_foreign_exchange() {
	    System.out.println("API for foreign Exchange");
	}

	@When("Posted with correct information")
	public void posted_with_correct_information() {
		System.out.println("Information posted");
	}

	@Then("Validate Positive response code received")
	public void validate_positive_response_code_received() {
		System.out.println("Positive response code");
	}

}
