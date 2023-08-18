package mandatoryHomeWork.mentorHomeWork.api.restfullBookingChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthCreation_Restful_Booking extends BaseClass {

	@Test(priority = 1)
	public void authCreation() {
		
		/*
		 * EndPoint : https://restful-booker.herokuapp.com 
		 * Pathparameter: /auth 
		 * Header : Content-Type: application/json
		 * Auth : null 
		 * Request Body: { "username" : "admin", "password" : "password123" }
		 * Method : Post
		 * 
		 */
		
		request.given()
				.body("{ \"username\" : \"admin\", \"password\" : \"password123\" }");
		
		Response responseBody = request.post("/auth");
		responseBody.prettyPrint();
		
		tokenValue = responseBody.jsonPath().get("token");
		System.out.println("Token value of auth >>>>>>>>>>>>>>>> "+tokenValue);
	}

	
}
