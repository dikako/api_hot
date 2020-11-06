package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import config.BaseTest;
import token.Token;

public class Follow extends BaseTest {
	
	@Test
	public void unfollowFirst() {		
		if (new function.User().userIdStatusCode() == 200) {
	
			lombok.Follow body = lombok.Follow.builder()
					.follow_to(new function.User().userId())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/unfollow")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body();
			
		} else {
			System.out.println("Status Code Not 200");
		}
	}
	
	@Test(dependsOnMethods = { "unfollowFirst" })
	public void follow() {		
		if (new function.User().userIdStatusCode() == 200) {
	
			lombok.Follow body = lombok.Follow.builder()
					.follow_to(new function.User().userId())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/follow")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("follow.json"));
		} else {
			System.out.println("Status Code Not 200");
		}
	}
	
	@Test(dependsOnMethods = { "follow" })
	public void unfollow() {		
		if (new function.User().userIdStatusCode() == 200) {
	
			lombok.Follow body = lombok.Follow.builder()
					.follow_to(new function.User().userId())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/unfollow")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("unfollow.json"));
		} else {
			System.out.println("Status Code Not 200");
		}
	}
	
	@Test(priority = 2)
	public void getFollowing() {
		if (new function.User().userIdStatusCode() == 200) {
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/following")
			.param("user_id", new function.User().userId())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("following.json"));
		} else {
			System.out.println("Status Code Not 200");
		}
	}
	
	@Test(priority = 3)
	public void getFollower() {
		if (new function.User().userIdStatusCode() == 200) {
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user/user-followers")
			.param("user_id", new function.User().userId())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("follower.json"));
		} else {
			System.out.println("Status Code Not 200");
		}
	}
}
