package Step_Definition;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Put {
	RequestSpecification request;
	Response response;
	@Given("Provided API for Update")
	public void provided_api_for_update() {
		System.out.println("Given");
		RestAssured.baseURI = "https://reqres.in";
		request = given().header("content-type", "application/json")
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}");
	}

	@When("URL provided and Updated the Correct Information")
	public void url_provided_and_updated_the_correct_information() {
		System.out.println("When");
		String path = "api/users/2";
		response = request.put(path).then().log().all().extract().response();
	}

	@Then("Updated msg is printed")
	public void updated_msg_is_printed() {
		System.out.println("Then");
		System.out.println("response status code : " + response.getStatusCode());
		System.out.println("response status line : " + response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		Assert.assertEquals(200, response.getStatusCode());
	}


}
