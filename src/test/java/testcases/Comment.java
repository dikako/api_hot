package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import config.BaseTestComment;
import function.ListCompetition;
import function.Video;
import token.Token;

public class Comment extends BaseTestComment {

	@Test
	public void commentUser() {		
		if (new ListCompetition().statusNow() == 200 & new Video().statusVideoIdCompetitionNow() == 200) {
			
			lombok.Comment body = lombok.Comment.builder()
					.message("dataqadata_ Good Videos I Think")
					.video_id(new Video().videoIdCompetitionNow())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/comments/user")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("user-comment.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(dependsOnMethods = { "commentUser" })
	public void getcommentUser() {		
		if (new ListCompetition().statusNow() == 200 & new Video().statusVideoIdCompetitionNow() == 200) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/comments/user")
			.param("video_id", new Video().videoIdCompetitionNow())
			.param("length", "10")
			.param("page", "1")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("get-user-comment.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}

}
