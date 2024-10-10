package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ReqResTest extends BaseTest {

	
	@Test
	public void getUserTest() {
		
		restClient.get("/api/users/2", true, false).then().assertThat().statusCode(200);
	}
	
}
