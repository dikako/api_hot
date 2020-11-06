package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import token.Token;

public class User extends BaseTest {
	
	@Test(priority = 0)
	public void getMyProfile() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/my-profile")
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("my-profile.json"));
	}
	
	@Test(priority = 1)
	public void getUserProfile() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/user-profile")
			.param("user_id", new function.User().userId())
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("my-profile.json"));
	}
	
	@Test(priority = 3)
	public void getMyVideo() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/my-videos")
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("my-videos.json"));
	}
	
	@Test(priority = 4)
	public void getMyCompetitions() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/my-competitions")
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("my-competition.json"));
	}
	
	@Test(priority = 5)
	public void getMyTask() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/my-task")
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("my-task.json"));
	}
	
	@Test(priority = 6)
	public void getUserVideo() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/user-videos")
			.param("user_id", new function.User().userId())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("user-video.json"));
	}

}
