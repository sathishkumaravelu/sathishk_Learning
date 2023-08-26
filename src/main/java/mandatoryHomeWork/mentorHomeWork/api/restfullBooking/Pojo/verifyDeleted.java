package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class verifyDeleted extends BaseClass{

	/*
	* EndPoint : https://restful-booker.herokuapp.com
	* Path parameter: 
	* Header : 'Content-Type: application/json'  // 'Cookie: token=abc123'
	* Auth : null
	* Request Body: 
	* Method :DELETE 
	* 
	*/
	
	@Test(priority = 7,dependsOnMethods ="mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.UpdateBooking_Restful_Booking.updateBooking")

	public void deleteBooking() {
	
		RequestSpecification deleteRequest = request
				.given()
				.header("Accept","application/json")
				.header("Cookie", "token="+tokenValue);

		deleteRequest.log().all();
		Response deleteResponseBody = deleteRequest.delete("/booking/"+bookingId);
		deleteResponseBody.prettyPrint();
		deleteResponseBody.then().assertThat().statusCode(201);
	}
	
}
