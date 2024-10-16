package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basetest.BaseTest;
import client.RestClient;
import consts.APIHttpStatus;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AmadeusAPITest extends BaseTest {
	
	private String accessToken;
	
	@Parameters({"baseURI", "grant_type","clientid","clientsecret"})
	@BeforeMethod
	public void setUp(String baseURI, String grantType, String clientID, String clientSecret) {
		restClient = new RestClient(prop, baseURI);
		accessToken = restClient.getAccessToken(baseURI,AMADEUS_ENDPOINT, grantType, clientID, clientSecret);
	}
	
	@Test
	public void flightBookingAPITest() {

		Map<String, Object> queryParam=new HashMap<String, Object>();
		queryParam.put("origin", "PAR");
		queryParam.put("maxPrice", "200");
		
		prop.setProperty("bearerToken", accessToken);
		
		Map<String, String> headers=new HashMap<String, String>();
		headers.put("Authorization", prop.getProperty("bearerToken"));
		
		RestClient restClient = new RestClient(prop, baseURI);
		
		Response flightdataResponse = restClient.get(AMADEUS_FLIGHTBOOKING_ENDPOINT, queryParam, headers , true, true)
			.then().assertThat().statusCode(APIHttpStatus.OK_200.getStatusCode()).extract().response();
		
		JsonPath jsonPath = flightdataResponse.jsonPath();
		String res = jsonPath.getString("data");
		
		System.out.println(res);
		
	
		System.out.println("Response: " + flightdataResponse.asPrettyString());
	}

}
