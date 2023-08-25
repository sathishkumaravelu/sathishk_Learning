package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PingCheck extends BaseClass{

	@Test(priority = 1)
	public void pingCheckMethod() {		
		Response pingRes = request.given()
		.basePath("ping").get();
		
		pingRes.then().statusCode(201);
	}
	
}
