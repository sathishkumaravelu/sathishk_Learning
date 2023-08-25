package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.AuthBodyResponse;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.AuthRequestBody;

public class AuthCreation_Restful_Booking extends BaseClass {

	@Test(priority = 2, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.PingCheck.pingCheckMethod")
	public void authCreation() {		
		AuthRequestBody req = new AuthRequestBody();
		req.setUsername("admin");
		req.setPassword("password123");
		
		
		request.given()
				.body(req);
		
		Response responseBody = request.post("/auth");
		responseBody.prettyPrint();
		AuthBodyResponse authResPojo = responseBody.getBody().as(AuthBodyResponse.class);
		tokenValue = authResPojo.gettoken();
		System.out.println("Token value of auth >>>>>>>>>>>>>>>> "+authResPojo.gettoken());
	}

	
}
