package tests;

import org.testng.annotations.Test;

import basetest.BaseCommonTest;
import consts.APIHttpStatus;

import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;

public class GetUserTest extends BaseCommonTest{
	
	
	@Test
	public void getAllUsersTest() {
		restClient.get(GOREST_ENDPOINT, true, true)
		.then().log().all()
		.assertThat().statusCode(APIHttpStatus.OK_200.getStatusCode());
	}
	
	
	@Test(enabled = true)
	public void getUserTest() {
		restClient.get(GOREST_ENDPOINT + "/7476157", true,true)
			.then().log().all()
				.assertThat().statusCode(APIHttpStatus.OK_200.getStatusCode())
					.and().body("id", equalTo(7476157));
	}
	
	@Test
	public void getUserWithQueryParamsTest() {
		
		Map<String, Object> queryParams=new HashMap<String, Object>();
		queryParams.put("gender", "female");
		queryParams.put("status", "inactive");
		
		restClient.get(GOREST_ENDPOINT ,queryParams,null, true, true)
		.then().log().all()
			.assertThat()
				.statusCode(APIHttpStatus.OK_200.getStatusCode());
	}

}
