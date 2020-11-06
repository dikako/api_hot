package testcases;

import org.testng.annotations.Test;
import config.BaseTest;
import function.ListCompetition;
import function.Video;
import lombok.Vote;
import token.Token;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class CompetitionVote extends BaseTest {
	
	@Test(priority = 0)
	public void getVoteQuotaCompetitionNow() {
		if (new ListCompetition().statusNow() ==  200) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().competitionIdNow())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote-quota.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 1)
	public void getVoteQuotaCompetitionSoon() {
		if (new ListCompetition().statusSoon() ==  200) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().competitionIdSoon())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote-quota.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 3)
	public void getVoteQuotaCompetitionExpired() {
		if (new ListCompetition().statusExpired() ==  200) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().competitionIdExpired())
			.header("Authorization", new Token().login())
			.when()
			.get()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote-quota.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 4)
	public void VoteCompetitionNow() {
		if (new ListCompetition().statusNow() ==  200) {
			
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdNow());
			
			Vote body = Vote.builder()
					.competition_id(competitionId)
					.contestant_id(new Video().userIdCompetitionNow())
					.vote_number(1)
					.video_id(new Video().videoIdCompetitionNow())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote-competition-now.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 5)
	public void VoteCompetitionSoon() {
		if (new ListCompetition().statusSoon() ==  200) {
			
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdSoon());
			
			Vote body = Vote.builder()
					.competition_id(competitionId)
					.contestant_id(new Video().userIdCompetitionSoon())
					.vote_number(1)
					.video_id(new Video().videoIdCompetitionSoon())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}
	
	@Test(priority = 6)
	public void VoteCompetitionExpired() {
		if (new ListCompetition().statusExpired() ==  200) {
			
			Integer competitionId = Integer.valueOf(new ListCompetition().competitionIdExpired());
			
			Vote body = Vote.builder()
					.competition_id(competitionId)
					.contestant_id(new Video().userIdCompetitionExpired())
					.vote_number(1)
					.video_id(new Video().videoIdCompetitionExpired())
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("vote.json"));
		} else {
			System.out.println("Data List Competition Id Kosong");
		}
	}

}
