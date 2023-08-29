package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.getBookingIdFilter_Pojo;

public class getBookingFilter extends BaseClass{

	
	
	@Test(priority = 4, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.CreateBooking_Restful_Booking.createBooking")
	public void getBookingFilterID() {
		
		Response response = request.given().header("accept","application/json").basePath("/booking/?firstname=Sathish").get();
		response.prettyPrint();		
		getBookingIdFilter_Pojo[] getRes = response.getBody().as(getBookingIdFilter_Pojo[].class);

		for (int i = 0; i < getRes.length; i++) {
			bookingid[] getbookingid = getRes[i].getbookingid();
			System.out.println(getbookingid);
		}
		response.then().assertThat().statusCode(200);
	

	}
	
}
