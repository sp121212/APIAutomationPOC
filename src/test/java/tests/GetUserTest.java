package tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import client.RestClient;

public class GetUserTest {
	
	RestClient restClient;
	
	@Test
	public void getAllUsersTest() {
		restClient=new RestClient();
		restClient.get("/public/v2/users", true)
			.then().log().all().assertThat().statusCode(200);
	}
	
	
	@Test
	public void getUserTest() {
		restClient=new RestClient();
		restClient.get("/public/v2/users/7450565", true)
			.then().log().all().assertThat()
				.statusCode(200)
					.and().body("id", equalTo(7450565));
	}
	
	@Test
	public void getUserWithQueryParamsTest() {
		
		Map<String,String> queryParams=new HashMap<String, String>();
		queryParams.put("gender", "female");
		queryParams.put("status", "inactive");
		
		restClient=new RestClient();
		restClient.get("/public/v2/users",queryParams,null, true)
			.then().log().all().assertThat()
				.statusCode(200);
	}

}
