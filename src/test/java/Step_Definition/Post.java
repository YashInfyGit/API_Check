package Step_Definition;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class Post {
	RequestSpecification request;
	Response response;
	@Given("API for testing")
	public void api_for_testing() {
		System.out.println("Given");
		RestAssured.baseURI = "https://reqres.in";
		request = given().header("content-type", "application/json")
				.body("{\r\n"
						+ "    \"name\": \"Jamie\",\r\n"
						+ "    \"job\": \"Tester\"\r\n"
						+ "}");
	}

	@When("Retrieve Correct Information")
	public void retrieve_correct_information() {
		System.out.println("When");
		String path = "api/users";
		response = request.post(path).then().log().all().extract().response();
	}

	@Then("Validate response status code using Assertion")
	public void validate_response_status_code_using_assertion() {
		System.out.println("Then");
		System.out.println("response status code : " + response.getStatusCode());
		System.out.println("response status line : " + response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(201, response.getStatusCode());
	}
}
