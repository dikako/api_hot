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
		} else {
			System.out.println("Data List Competition Id Kosong");			
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
		} else {
			System.out.println("Data List Competition Id Kosong");
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
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 4)
	public void JoinCompetitionNow() {		
		if (new ListCompetition().statusNow() == 200 ) {
			
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdNow());
	
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(competitionId)
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
		if (new ListCompetition().statusExpired() == 200) {
	
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdExpired());
			
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(competitionId)
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
		if (new ListCompetition().statusSoon() == 200) {
	
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdSoon());
			
			JoinCompetition body = JoinCompetition.builder()
					.competition_id(competitionId)
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
		if (new ListCompetition().statusNow() == 200) {
			
			String competitionId = new ListCompetition().competitionIdNow();
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
		if (new ListCompetition().statusSoon() == 200) {
			
			String competitionId = new ListCompetition().competitionIdSoon();
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
		if (new ListCompetition().statusExpired() == 200) {
			
			String competitionId = new ListCompetition().competitionIdExpired();
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
		if (new ListCompetition().statusNow() == 200) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().competitionIdNow() + "/videos")
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
		if (new ListCompetition().statusSoon() == 200) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().competitionIdSoon() + "/videos")
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
		if (new ListCompetition().statusExpired() == 200) {
		
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/competition/" + new ListCompetition().competitionIdExpired() + "/videos")
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
	
	@Test(priority = 14)
	public void getLeaderboard() {
		
		if (new ListCompetition().statusNow() == 200) {
		given()
		.spec(requestSpecificationToMerge)
		.basePath("/competition/leaderboard")
		.param("competition_id", new ListCompetition().competitionIdNow())
		.header("Authorization", new Token().visitor())
		.when()
		.get()
		.then()
		.log().body()
		.body(matchesJsonSchemaInClasspath("leaderboard.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}

}
