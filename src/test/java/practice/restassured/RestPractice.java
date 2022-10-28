package practice.restassured;

import static io.restassured.RestAssured.given;

import org.codehaus.groovy.runtime.metaclass.MethodHelper;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class RestPractice extends MethodHelper {

	@Test(description = "Get list of all users and print them as table in the console")
	public void test1() {

		ValidatableResponse response = given().queryParam("page", "1").accept(ContentType.JSON)
				.contentType(ContentType.JSON).get("https://reqres.in/api/users").then();

		response.statusCode(200).log().all();
		System.out.println(response.statusCode(200).log().all().getClass().toString());

	}
}
