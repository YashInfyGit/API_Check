package Step_Definition;



import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class Get {
	RequestSpecification request;
	Response response;
	@Given("User is on netbanking landing page")
	public void user_is_on_netbanking_landing_page() {
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
	}

	@When("User logging into app using credentials")
	public void user_logging_into_app_using_credentials() {
		System.out.println("When");
		String path="api/users/2";
		response=request.get(path).then().log().all().extract().response();
	}

	@Then("Home is populated")
	public void home_is_populated() {
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		Assert.assertEquals(200, response.getStatusCode());
	}

	
}
