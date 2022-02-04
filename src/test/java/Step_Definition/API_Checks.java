package Step_Definition;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API_Checks {
	
	private static final String BASE_URL = "https://reqres.in";
	private static Response response;
	
	@Given("API for Foreign Exchange")
	public void api_for_foreign_exchange() {
	    RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/api/users/2");
	}

	@When("Posted with correct information")
	public void posted_with_correct_information() {
		System.out.println("Information posted Correctly");
	}

	@Then("Validate Positive response code received")
	public void validate_positive_response_code_received() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response2 = httpRequest.get("/api/users/2");		
		System.out.println("Response Body is =>  " + response2.asString());
	}

}
