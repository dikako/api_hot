package testcases;

import org.testng.annotations.Test;
import config.BaseTest;
import function.ListCompetition;
import lombok.JoinCompetition;
import token.Token;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class Competition extends BaseTest {
	
	@Test(priority = 0)
	public void getCompetitionList() {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition-list")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("list-competition.json"));
	
	}
	
	@Test(priority = 1)
	public void getNowCompetition() {
		
		if (new ListCompetition().statusListCompetition() == 200) {
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/competition/now-competition")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("now-competition.json"));
		}
	}
	
	@Test(priority = 2)
	public void getSoonCompetition() {
		
		if (new ListCompetition().statusListCompetition() == 200) {
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/competition/soon-competition")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("soon-competition.json"));
		}
	}
	
	@Test(priority = 3)
	public void getExpiredCompetition() {
		
		if (new ListCompetition().statusListCompetition() == 200) {
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/competition/expired-competition")
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("expired-competition.json"));
		}
	}
	
	@Test(priority = 4)
	public void JoinCompetitionNow() {		
		if (new ListCompetition().now() != 0) {
	
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(new ListCompetition().now())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/join-competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("join-competition-now.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 5)
	public void JoinCompetitionExpired() {		
		if (new ListCompetition().expired() != 0) {
	
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(new ListCompetition().expired())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/join-competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("join-competition-expired.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 6)
	public void JoinCompetitionSoon() {		
		if (new ListCompetition().soon() != 0) {
	
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(new ListCompetition().soon())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/join-competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("join-competition-soon.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 7)
	public void getDetailCompetitionNow() {
		if (new ListCompetition().now() != 0) {
			
			String competitionId = String.valueOf(new ListCompetition().now());
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/detail/" + competitionId)
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("detail-competition.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 8)
	public void getDetailCompetitionSoon() {
		if (new ListCompetition().soon() != 0) {
			
			String competitionId = String.valueOf(new ListCompetition().soon());
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/detail/" + competitionId)
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("detail-competition.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 9)
	public void getDetailCompetitionExpired() {
		if (new ListCompetition().expired() != 0) {
			
			String competitionId = String.valueOf(new ListCompetition().expired());
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/detail/" + competitionId)
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("detail-competition.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 10)
	public void getCompetitionNowVideo() {
		if (new ListCompetition().now() != 0) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().now() + "/videos")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("competition-now-video.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 11)
	public void getCompetitionSoonVideo() {
		if (new ListCompetition().soon() != 0) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().soon() + "/videos")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("competition-now-video.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 12)
	public void getCompetitionExpiredVideo() {
		if (new ListCompetition().expired() != 0) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().expired() + "/videos")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("competition-now-video.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 13)
	public void getCompetitionUpload() {

			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/competition_upload")
			.header("Authorization", new Token().visitor())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("competition-upload.json"));

	}

}
