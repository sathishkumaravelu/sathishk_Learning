package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingRes;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.bookingdates;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.updateResBody;

public class UpdateBooking_Restful_Booking extends BaseClass {

	@Test(priority = 5, dependsOnMethods = {"mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.GetBooking.getBooking"})
	public void updateBooking() {

		/*
		 * EndPoint : https://restful-booker.herokuapp.com/ 
		 * Pathparameter: /booking/id
		 * Header : Content-Type: application/json / Accept: application/json /Cookie:
		 * token=abc123 
		 * Auth : null 
		 * Request Body: { "firstname" : "James", "lastname" :
		 * "Brown", "totalprice" : 111, "depositpaid" : true, "bookingdates" : {
		 * "checkin" : "2018-01-01", "checkout" : "2019-01-01" }, "additionalneeds" :
		 * "Breakfast" } 
		 * Method :put
		 * 
		 */

		CreateBookingReq req = new CreateBookingReq();
		req.setFirstname("Guna");
		req.setLastname("Kumaravelu");
		req.setTotalprice("121");
		req.setDepositpaid(true);
		bookingdates checkingDates = new bookingdates();
		checkingDates.setCheckin("2018-01-01");
		checkingDates.setCheckout("2018-01-01");
		req.setBookingdates(checkingDates);
		req.setAdditionalneeds("extra bed");
		
				RequestSpecification requestBody = request.given()
				   .header("Accept","application/json")
				   .header("Cookie","token="+tokenValue)
				   .body(req);
		
		requestBody.log().all();
		
		
		System.out.println("-----------Response Body--------------");
		Response responseBody = requestBody.put("/booking/"+bookingId);
		responseBody.prettyPrint();
		
		updateResBody updateBookingRes = responseBody.getBody().as(updateResBody.class);
		responseBody.then().assertThat().statusCode(200);
		Assert.assertEquals(updateBookingRes.getFirstname(), req.getFirstname());
	}
}
