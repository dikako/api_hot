package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import config.BaseTest;
import function.ListCompetition;
import function.Video;
import lombok.View;
import token.Token;

public class VideoView extends BaseTest {
	
	@Test(priority = 0)
	public void viewVideo() {
		if (new ListCompetition().now() != 0) {
			
			View body = View.builder()
					.video_id(new Video().videoIdCompetitionNow())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/views")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("video-view.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}

}
