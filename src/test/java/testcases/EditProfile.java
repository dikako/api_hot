package testcases;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import config.BaseTest;
import lombok.EditUser;
import token.Token;

public class EditProfile extends BaseTest {
	
	Faker data = new Faker();
	
	@Test(priority = 0)
	public void editGender() {		
		
			EditUser body = EditUser.builder()
					.gender("male")
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("edit-gender.json"));
	}
	
	@Test(priority = 1)
	public void editFullname() {		
		
			String text = data.name().firstName();
			
			EditUser body = EditUser.builder()
					.fullname(text)
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("edit-fullname.json"));
	}
	
	@Test(priority = 2)
	public void editNickname() {	
		
		String text = data.name().lastName();
			
			EditUser body = EditUser.builder()
					.nickname(text)
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("edit-nickname.json"));
	}
	
	@Test(priority = 3)
	public void editDob() {		
			
			EditUser body = EditUser.builder()
					.dob("1998-11-04")
					.build();
			
			given()
			.spec(requestSpecificationToMerge)
			.basePath("/user")
			.header("Authorization", new Token().login())
			.body(body)
			.log().all()
			.when()
			.post()
			.then()
			.log().body()
			.body(matchesJsonSchemaInClasspath("edit-dob.json"));
	}
}
