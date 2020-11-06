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

public int statusVideoIdCompetitionNow() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdNow() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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

public int statusVideoIdCompetitionSoon() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdSoon() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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

public int statusVideoIdCompetitionExpired() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdExpired() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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

public int statusUserIdCompetitionNow() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdNow() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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

public int statusUserIdCompetitionSoon() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdSoon() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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

public int statusUserIdCompetitionExpired() {
	
	return given()
	.spec(requestSpecificationToMerge)
	.basePath("/competition/" + new ListCompetition().competitionIdExpired() +"/videos")
	.header("Authorization", new Token().visitor())
	.when()
	.get()
	.thenReturn()
	.getStatusCode();
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
