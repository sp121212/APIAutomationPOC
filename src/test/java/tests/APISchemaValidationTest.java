package tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;
import consts.APIHttpStatus;
import pojo.Users;
import utils.StringSutil;

public class APISchemaValidationTest extends BaseTest{
	
	@Parameters({"baseURI"})
	@BeforeMethod
	public void setUp() {
		restClient =  new RestClient(prop, baseURI);
	}

	@Test
	public void createUserAPIScehemaTest() {
		Users user=new Users("Niko", StringSutil.getRandomEmailId(), "male", "active");
		
		restClient.post(GOREST_ENDPOINT , "json", user, true, true)
				.then().log().all()
					.assertThat().statusCode(APIHttpStatus.CREATED_201.getStatusCode())
						.body(matchesJsonSchemaInClasspath("createuser.json"));
		
		
	}
}
