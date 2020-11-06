package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import function.ListCompetition;
import lombok.UploadVideo;
import token.Token;

public class Video extends BaseTest {

	@Test(priority = 0)
	public void getDetailVideo() {
		if (new ListCompetition().statusNow() == 200 & new function.Video().statusVideoIdCompetitionNow() == 200) {
			
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/play")
		.param("video_id", new function.Video().videoIdCompetitionNow())
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("detail-video.json"));

		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 1)
	public void uploadVideo() {
		if (new ListCompetition().statusNow() == 200) {
			
			Integer categoryId = Integer.valueOf(new function.Home().homeSectionId());
			
			UploadVideo body = UploadVideo.builder()
					.category_id(categoryId)
					.competition_id(new ListCompetition().now())
					.video_title("qadata_upload")
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/upload_data")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("upload-video.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
}
