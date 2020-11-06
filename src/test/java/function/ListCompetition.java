package function;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import config.BaseTest;
import token.Token;

public class ListCompetition extends BaseTest {
	
	public int statusListCompetition() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition-list")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.thenReturn()
				.getStatusCode();
	}

	public int statusNow() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/now-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.thenReturn()
				.getStatusCode();
	}

	public String competitionIdNow() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/now-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.getBody()
				.path("data[0].competition_id").toString();
	}
	
	public int statusSoon() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/soon-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.thenReturn()
				.getStatusCode();
	}
	
	public String competitionIdSoon() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/soon-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.getBody()
				.path("data[0].competition_id").toString();
	}
	
	public int statusExpired() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/expired-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.thenReturn()
				.getStatusCode();
	}

	public String competitionIdExpired() {
		return given()
				.spec(requestSpecificationToMerge)
				.basePath("/competition/expired-competition")
				.header("Authorization", new Token().visitor())
				.when()
				.get()
				.getBody()
				.path("data[0].competition_id").toString();
	}
	
	public int now() {
		int competitionId = 0;
		
		if (statusNow() == 200) {
			Integer competitionIdNow = Integer.valueOf(competitionIdNow());
			competitionId = competitionIdNow;
		} else {
			return 0;
		}
		
		return competitionId;
	}
	
	public int soon() {
		int competitionId = 0;
		
		if (statusSoon() == 200) {
			Integer competitionIdSoon = Integer.valueOf(competitionIdSoon());
			competitionId = competitionIdSoon;
		} else {
			return 0;
		}
		
		return competitionId;
	}
	
	public int expired() {
		int competitionId = 0;
		
		if (statusExpired() == 200) {
			Integer competitionIdExpired = Integer.valueOf(competitionIdExpired());
			competitionId = competitionIdExpired;
		} else {
			return 0;
		}
		
		return competitionId;
	}
	
	public int competitionNow() {
		
		return 1;
	}
	
	public int competitionSoon() {
		
		return 2;
	}
	
	public int competitionExpired() {
		
		return 3;
	}
	
	@Test
	public void test() {
		System.out.println(statusNow());
	}

}
