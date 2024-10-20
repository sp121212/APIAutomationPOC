package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;
import consts.APIHttpStatus;
import elements.CircuitAPI;
import io.restassured.response.Response;
import utils.JSONPathValidator;

public class CircuitTest extends BaseTest {
	
	@BeforeMethod
	public void setUp() {
		restClient=new RestClient(prop, baseURI);
	}
	
	@Test
	public void getCircuitDetailsTest() {
	Response circuitResponse =	restClient.get(CIRCUIT_ENDPOINT+ "/2017/circuits.json" , true, false);
	
	System.out.println(circuitResponse.asString());
	
	int statusCode = circuitResponse.statusCode();
	Assert.assertEquals(statusCode, APIHttpStatus.OK_200.getStatusCode());
	
	JSONPathValidator jpv = new JSONPathValidator();
	List<String> countryName = jpv.readList(circuitResponse, CircuitAPI.getCountryNameThroughCircuitID("albert_park"));
	//System.out.println("countryName " + countryName); 
	Assert.assertTrue(countryName.contains("Australia"), "Country name is matched");
	
	}
}
