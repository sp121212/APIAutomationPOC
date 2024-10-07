package tests;

import org.testng.annotations.Test;

import client.RestClient;
import pojo.Users;
import utils.StringSutil;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {
	
	RestClient  restClient;
	
	@Test
	public void createUserTest() {
		restClient = new RestClient();
		Users user=new Users("Deepak", StringSutil.getRandomEmailId(), "male", "active");
		
		int userId=restClient.post("/public/v2/users", "json", user, true)
				.then().log().all()
					.assertThat().statusCode(201)
						.extract().path("id");
		
		System.out.println("USER ID : " + userId);
		
		System.out.println("\n------------------------------------------");
	
		//Validate the user
		restClient.get("/public/v2/users/" + userId, true)
			.then().log().all()
				.assertThat().statusCode(200)
						//.extract().body().toString();
				.assertThat().body("id", equalTo(userId));
		
		
	}

}
