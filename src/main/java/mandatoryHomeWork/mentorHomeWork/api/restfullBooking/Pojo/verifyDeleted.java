package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;

public class verifyDeleted extends BaseClass{

	/*
	* EndPoint : https://restful-booker.herokuapp.com
	* Path parameter: 
	* Header : 'Content-Type: application/json'  // 'Cookie: token=abc123'
	* Auth : null
	* Request Body: 
	* Method :GET 
	* 
	*/
	
	@Test(priority = 7,dependsOnMethods ="mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.DeleteBooking_Restful_Booking.deleteBooking")
	public void verifyDeleteBooking() {
	
		Response response = request.given().header("accept","application/json").basePath("/booking/"+bookingId).get();
		response.prettyPrint();
		response.then().assertThat().statusCode(404);
	}
	
}
