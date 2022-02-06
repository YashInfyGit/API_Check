package RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class RestAssured {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	//GET Call
//	Response res1 = given().log().all().queryParam("page", "2")
//			.header("Content-Type","jason")
//			.when().get("http://reqres.in/api/user/2")
//			.then().log().all().statusCode(200).extract().response();
	//PUT Call
//	Response res2 = (Response) given().log().all()
//			.header("Content-Type","jason")
//			.body("{\r\n"
//					+ "    \"name\": \"morpheus\",\r\n"
//					+ "    \"job\": \"zion resident\"\r\n"
//					+ "}")
//			.when().put("https://reqres.in/api/users/2")
//			.then().log().all().statusCode(200).extract().response();
	//POST Call
	Response res3 = given().log().all().header("Content-Type","jason")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
			.when().post("https://reqres.in/api/users")
			.then().log().all().statusCode(201).extract().response();

}

}
