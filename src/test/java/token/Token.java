package token;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Login;

public class Token {

	RequestSpecification requestSpecificationToMerge = new RequestSpecBuilder()
			.setBaseUri("https://rc-api.rctiplus.com/api")
			.setContentType(ContentType.JSON).build();

	public String visitor() {

		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/v1/visitor")
				.param("platform", "mweb")
				.param("device_id", "46346")
				.when()
				.get()
				.getBody()
				.path("data.access_token").toString();

	}

	public String login() {

		Login body = Login.builder()
				.username("dikakoko04@gmail.com")
				.password("dikakoko")
				.device_id("04111998")
				.platform("mweb")
				.build();

		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/v3/login")
				.header("Authorization", visitor())
				.body(body)
				.when()
				.post()
				.getBody()
				.path("data.access_token").toString();

	}
	
	@Test
	public void test() {
		System.out.println(login());
	}
}
