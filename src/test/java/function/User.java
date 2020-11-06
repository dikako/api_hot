package function;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import token.Token;

public class User extends BaseTest {
	
public int userIdStatusCode() {
		
		return given()
		.spec(requestSpecificationToMerge)
		.basePath("/search/users?q=" + new ListCompetition().now() +"/videos")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.thenReturn()
		.getStatusCode();
	}
	
	public int userId() {
		
		return given()
		.spec(requestSpecificationToMerge)
		.basePath("/search/users?q=" + new ListCompetition().now() +"/videos")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.getBody()
		.path("data[0].user_id");
	}
	
	@Test
	public void test() {
		System.out.println(userId());
	}

}
