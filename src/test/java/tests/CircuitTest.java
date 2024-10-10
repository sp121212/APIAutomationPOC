package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class CircuitTest extends BaseTest {

	
	@Test
	public void getCircuitDetailsTest() {
		restClient.get("/api/f1/2017/circuits.json", true, false)
		.then().log().all().assertThat().statusCode(200);
	}
}
