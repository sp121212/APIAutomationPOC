package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;
import consts.APIHttpStatus;

public class ReqResTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
		restClient=new RestClient(prop, baseURI);
	}
	
	@Test
	public void getUserTest() {
		
		restClient.get(REQRES_ENDPOINT+"/2", true, false).then().assertThat().statusCode(APIHttpStatus.OK_200.getStatusCode());
	}
	
}
