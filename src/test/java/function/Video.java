package function;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import token.Token;

public class Video extends BaseTest {
	
public int videoIdCompetitionNow() {
		
		return given()
		.spec(requestSpecificationToMerge)
		.basePath("/competition/" + new ListCompetition().competitionIdNow() +"/videos")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.getBody()
		.path("data[0].video_id");
	}

public int videoIdCompetitionSoon() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdSoon() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].video_id");
}

public int videoIdCompetitionExpired() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdExpired() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].video_id");
}

public int userIdCompetitionNow() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdNow() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].author.user_id");
}

public int userIdCompetitionSoon() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdSoon() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].author.user_id");
}

public int userIdCompetitionExpired() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdExpired() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].author.user_id");
}

public String videoTitleCompetitionNow() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdNow() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.getBody()
	.path("data[0].title").toString();
}

	@Test
	public void test() {
		System.out.println(videoTitleCompetitionNow());
	}
}
