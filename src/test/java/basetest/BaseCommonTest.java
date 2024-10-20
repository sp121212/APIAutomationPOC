package basetest;

import org.testng.annotations.BeforeMethod;

import client.RestClient;

public class BaseCommonTest extends BaseTest{

	@BeforeMethod
	public void setUp() {
		restClient=new RestClient(prop, baseURI);
	}
}
