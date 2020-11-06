package config;

import org.testng.annotations.BeforeMethod;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTestComment {

	protected RequestSpecification requestSpecificationToMerge = new RequestSpecBuilder()
//			.setBaseUri("https://rc-api.rctiplus.com/ugc-comment/api/v1")
			.setBaseUri("https://api-hot.rctiplus.com/ugc-comment/api/v1")
			.setContentType(ContentType.JSON)
			.build();

	@BeforeMethod
	public void setFilter() {
		RestAssured.filters(new AllureRestAssured());
	}

}
