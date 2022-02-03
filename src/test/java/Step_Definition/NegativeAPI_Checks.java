package Step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeAPI_Checks {
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {
	    System.out.println("Step- API Check");
	}

	@When("posted with correct information")
	public void posted_with_correct_information() {
		System.out.println("Step- Posted Information");
	}

	@Then("Validate positive response code received")
	public void validate_positive_response_code_received() {
		System.out.println("Step- Response Received");
	}

}
