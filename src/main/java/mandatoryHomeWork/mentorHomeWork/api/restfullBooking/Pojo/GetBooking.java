package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingRes;

public class GetBooking extends BaseClass {

	@Test(priority = 4, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.restfullBooking.Pojo.CreateBooking_Restful_Booking.createBooking")
	public void getBooking() {
		
		Response response = request.given().header("accept","application/json").basePath("/booking/"+bookingId).get();
		response.prettyPrint();
		CreateBookingReq getRes = response.getBody().as(CreateBookingReq.class);
		
		response.then().assertThat().statusCode(200);
	
		Assert.assertEquals(firstNameExpected, getRes.getFirstname());
		Assert.assertEquals(lastNameExpected, getRes.getLastname());
		Assert.assertEquals(additionalNeedsExpected, getRes.getAdditionalneeds());
	}
	

}
