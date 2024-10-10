package basetest;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import client.RestClient;
import config.ConfigurationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {

	ConfigurationManager config;
	Properties prop;
	protected RestClient restClient;
	
	@Parameters({"baseURI"})
	@BeforeTest
	public void setUp(String baseURI) {
		RestAssured.filters(new AllureRestAssured());
		config = new ConfigurationManager();
		prop = config.initProp();
//		String baseURI = prop.getProperty("baseuri");
		restClient = new RestClient(prop, baseURI);
		
	}
	
}
