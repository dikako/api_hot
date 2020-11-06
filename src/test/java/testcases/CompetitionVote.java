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
		if (new ListCompetition().now() !=  0) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().now())
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
		if (new ListCompetition().soon() !=  0) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().soon())
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
		if (new ListCompetition().expired() !=  0) {
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/vote/competition")
			.param("competition_id", new ListCompetition().expired())
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
		if (new ListCompetition().now() !=  0) {
			
			Vote body = Vote.builder()
					.competition_id(new ListCompetition().now())
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
		if (new ListCompetition().soon() !=  0) {
			
			Vote body = Vote.builder()
					.competition_id(new ListCompetition().soon())
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
		if (new ListCompetition().expired() !=  0) {
			
			Vote body = Vote.builder()
					.competition_id(new ListCompetition().expired())
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
