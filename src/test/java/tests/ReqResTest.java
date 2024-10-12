package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;

public class ReqResTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
		restClient=new RestClient(prop, baseURI);
	}
	
	@Test
	public void getUserTest() {
		
		restClient.get("/api/users/2", true, false).then().assertThat().statusCode(200);
	}
	
}
