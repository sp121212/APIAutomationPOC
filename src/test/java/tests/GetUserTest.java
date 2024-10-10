package tests;

import org.testng.annotations.Test;
import basetest.BaseTest;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;

public class GetUserTest extends BaseTest{
	
	
	@Test
	public void getAllUsersTest() {
		restClient.get("/public/v2/users", true, true)
			.then().log().all().assertThat().statusCode(200);
	}
	
	
//	@Test
//	public void getUserTest() {
//		restClient.get("/public/v2/users/7450565", true)
//			.then().log().all().assertThat()
//				.statusCode(200)
//					.and().body("id", equalTo(7450565));
//	}
//	
//	@Test
//	public void getUserWithQueryParamsTest() {
//		
//		Map<String,String> queryParams=new HashMap<String, String>();
//		queryParams.put("gender", "female");
//		queryParams.put("status", "inactive");
//		
//		restClient.get("/public/v2/users",queryParams,null, true)
//			.then().log().all().assertThat()
//				.statusCode(200);
//	}

}
