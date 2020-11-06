package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import token.Token;

public class Search extends BaseTest {
	
	@Test(priority = 0)
	public void getSearchVideo() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/search/videos")
			.param("q", "")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("search-video.json"));
	
	}
	
	@Test(priority = 1)
	public void getSearchUser() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/search/users")
			.param("q", "")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("search-user.json"));
	
	}

}
