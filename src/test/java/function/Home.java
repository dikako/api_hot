package function;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import config.BaseTest;
import token.Token;

public class Home extends BaseTest {
	
	public String homeId() {
		
		return given()
		.spec(requestSpecificationToMerge)
		.basePath("/home")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.getBody()
		.path("data[0].id").toString();
	}
	
	public String homeSectionId() {
		
		return given()
		.spec(requestSpecificationToMerge)
		.basePath("/home/" + homeId())
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.getBody()
		.path("data[0].id").toString();
	}
	
	@Test
	public void test() {
		System.out.println(homeId());
	}
}
