package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingRes;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.bookingdates;

public class CreateBooking_Restful_Booking extends BaseClass{
	
	@Test(priority = 3, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.AuthCreation_Restful_Booking.authCreation")
	public void createBooking() {
		/*
		 * EndPoint : https://restful-booker.herokuapp.com 
		 * Pathparameter: /booking
		 * Header : Content-Type: application/json 
		 * Auth : null 
		 * Request Body: {
		 * "firstname" : "Jim", "lastname" : "Brown", "totalprice" : 111, "depositpaid"
		 * : true, "bookingdates" : { "checkin" : "2018-01-01", "checkout" :
		 * "2019-01-01" } ,"additionalneeds" : "Breakfast"}
		 * Method :post()
		 */
		
		
		CreateBookingReq req = new CreateBookingReq();
		req.setFirstname("Sathish");
		req.setLastname("Kumaravelu");
		req.setTotalprice("121");
		req.setDepositpaid(true);
		bookingdates checkingDates = new bookingdates();
		checkingDates.setCheckin("2018-01-01");
		checkingDates.setCheckout("2018-01-01");
		req.setBookingdates(checkingDates);
		req.setAdditionalneeds("extra bed");
		
		RequestSpecification requestBody = request.given()
				   .body(req);
		 requestBody.log().everything();
		 System.out.println("----------------------------------");
		 Response responseBody = requestBody.post("/booking");

			responseBody.body().prettyPrint();
			CreateBookingRes createBookingRes = responseBody.getBody().as(CreateBookingRes.class);
			bookingId = createBookingRes.getBookingid();
			firstNameExpected= createBookingRes.getBooking().getFirstname();
			lastNameExpected= createBookingRes.getBooking().getLastname();
			additionalNeedsExpected= createBookingRes.getBooking().getAdditionalneeds();
			
			//bookingId = responseBody.jsonPath().get("bookingid");
			System.out.println("Booking id -------------> :" + bookingId);

			responseBody.then().assertThat().statusCode(200);
			responseBody.then().body("booking.firstname", Matchers.containsString(req.getFirstname()));
			
		 
	
	}
}
