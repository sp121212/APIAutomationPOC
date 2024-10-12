package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;

public class CircuitTest extends BaseTest {
	
	@BeforeMethod
	public void setUp() {
		restClient=new RestClient(prop, baseURI);
	}
	
	
	@Test
	public void getCircuitDetailsTest() {
		restClient.get("/api/f1/2017/circuits.json", true, false)
		.then().log().all().assertThat().statusCode(200);
	}
}
