package testcases;

import org.testng.annotations.Test;
import config.BaseTest;
import token.Token;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class Home extends BaseTest {
	
	@Test(priority = 0)
	public void getHome() {
		
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/home")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("home.json"));
	}
	
	@Test(priority = 1)
	public void getHomeByCategory() {
	
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/home/" + new function.Home().homeId())
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("home-by-category.json"));
	}
	
	@Test(priority = 2)
	public void getHomeByCategoryBySection() {
		
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/home/" + new function.Home().homeId() + "/videos/" + new function.Home().homeSectionId())
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("home-by-category-by-section.json"));
	}
}
