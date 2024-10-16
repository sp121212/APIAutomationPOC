package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basetest.BaseCommonTest;
import consts.APIHttpStatus;
import consts.ApiConstants;
import pojo.Users;
import utils.ExcelUtil;
import utils.StringSutil;
import static org.hamcrest.Matchers.equalTo;


public class CreateUserTest extends BaseCommonTest{
	
	@DataProvider
	public Object[][] getTestData() {
		return new Object[][] {
				{"Raju","male","active"},
				{"Devu","male","inactive"},
				{"Diva","female","active"}
				};
	}
	
	@DataProvider
	public Object[][] getTestSheetData(){
		return ExcelUtil.getTestData(ApiConstants.GOREST_USER_NAME);
	}
	
	
	@Test( dataProvider = "getTestSheetData")
	public void createUserTest(String name, String gender, String status) {
		Users user=new Users(name, StringSutil.getRandomEmailId(), gender, status);
		
		int userId = restClient.post(GOREST_ENDPOINT , "json", user, true, true)
				.then().log().all()
					.assertThat().statusCode(APIHttpStatus.CREATED_201.getStatusCode())
						.extract().path("id");
		
		System.out.println("USER ID : " + userId);
		
		System.out.println("\n------------------------------------------");
	
		
		//Validate the user
		restClient.get(GOREST_ENDPOINT +"/"+ userId, true, true)
			.then().log().all()
				.assertThat().statusCode(APIHttpStatus.OK_200.getStatusCode())
						//.extract().body().toString();
				.assertThat().body("id", equalTo(userId));
	}
	
}
