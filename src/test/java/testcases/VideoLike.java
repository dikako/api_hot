package testcases;

import org.testng.annotations.Test;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import config.BaseTest;
import function.ListCompetition;
import function.Video;
import lombok.Like;
import token.Token;

public class VideoLike extends BaseTest {
	
	@Test(priority = 0)
	public void likeVideo() {
		if (new ListCompetition().now() != 0) {
			
			Like body = Like.builder()
					.type("like")
					.video_id(new Video().videoIdCompetitionNow())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/likes")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("video-like.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 1)
	public void unlikeVideo() {
		if (new ListCompetition().now() != 0) {
			
			Like body = Like.builder()
					.type("unlike")
					.video_id(new Video().videoIdCompetitionNow())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/likes")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("video-like.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
}
