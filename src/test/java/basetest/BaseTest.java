package basetest;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import client.RestClient;
import config.ConfigurationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {

	//Service URL
	public static final String GOREST_ENDPOINT = "/public/v2/users";
	public static final String REQRES_ENDPOINT = "/api/users";
	public static final String CIRCUIT_ENDPOINT  = "/api/f1";
	public static final String AMADEUS_ENDPOINT  = "/v1/security/oauth2/token";
	public static final String AMADEUS_FLIGHTBOOKING_ENDPOINT  ="v1/shopping/flight-destinations";
	ConfigurationManager config;
	protected Properties prop;
	protected RestClient restClient;
	protected String baseURI;
	
	@Parameters({"baseURI"})
	@BeforeTest
	public void setUp(String baseURI) {
		RestAssured.filters(new AllureRestAssured());
		config = new ConfigurationManager();
		prop = config.initProp();
		prop.setProperty("baseuri", baseURI);
		this.baseURI = prop.getProperty("baseuri");
	}
	
}
