package mandatoryHomeWork.mentorHomeWork.api.pojo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.AuthBodyResponse;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.AuthRequestBody;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingRes;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.Delete_Deserialize_Pojo;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.bookingdates;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.getBookingIdFilter_Pojo;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.updateResBody;

public class Tc_PojoChaining extends BaseClass {

	@Test(priority = 1)
	public void pingCheckMethod() {		
		Response pingRes = request.given().basePath("ping").get();		
		pingRes.then().statusCode(201);
		Assert.assertEquals(pingRes.getStatusCode(), 201);
	}
	
	@Test(priority = 2, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.pojo.Tc_PojoChaining.pingCheckMethod")
	public void authCreation() {		
		AuthRequestBody req = new AuthRequestBody();
		req.setUsername("admin");
		req.setPassword("password123");
		request.given().body(req);
		Response responseBody = request.post("auth");
		responseBody.prettyPrint();
		AuthBodyResponse authResPojo = responseBody.getBody().as(AuthBodyResponse.class);
		tokenValue = authResPojo.gettoken();
		Assert.assertNotNull("token value not generate", tokenValue);
		System.out.println("Token value of auth >>>>>>>>>>>>>>>> "+authResPojo.gettoken());
	}

	@Test(priority = 3, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.pojo.Tc_PojoChaining.authCreation")
	public void createBooking() {
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
		RequestSpecification requestBody = request.given().body(req);
		 requestBody.log().everything();
		 System.out.println("----------------------------------");
		 Response responseBody = requestBody.post("booking");
			responseBody.body().prettyPrint();
			CreateBookingRes createBookingRes = responseBody.getBody().as(CreateBookingRes.class);
			bookingId = createBookingRes.getBookingid();
			firstNameExpected= createBookingRes.getBooking().getFirstname();
			lastNameExpected= createBookingRes.getBooking().getLastname();
			additionalNeedsExpected= createBookingRes.getBooking().getAdditionalneeds();
			System.out.println("Booking id -------------> :" + bookingId);
			responseBody.then().assertThat().statusCode(200);
			Assert.assertEquals(createBookingRes.getBooking().getFirstname(), req.getFirstname());
			Assert.assertEquals(createBookingRes.getBooking().getLastname(), req.getLastname());
			Assert.assertEquals(createBookingRes.getBooking().getAdditionalneeds(), req.getAdditionalneeds());
	}
	
	@Test(priority = 4, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.pojo.Tc_PojoChaining.createBooking")
	public void getBooking() {
		Response response = request.given().header("accept","application/json").basePath("/booking/"+bookingId).get();
		response.prettyPrint();
		CreateBookingReq getRes = response.getBody().as(CreateBookingReq.class);
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(firstNameExpected, getRes.getFirstname());
		Assert.assertEquals(lastNameExpected, getRes.getLastname());
		Assert.assertEquals(additionalNeedsExpected, getRes.getAdditionalneeds());
	}

	@Test(priority = 5, dependsOnMethods = {"mandatoryHomeWork.mentorHomeWork.api.Pojo.Tc_PojoChaining.getBooking"})
	public void updateBooking() {
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
	
	@Test(priority = 6, dependsOnMethods = "mandatoryHomeWork.mentorHomeWork.api.Pojo.Tc_PojoChaining.createBooking")
	public void getBookingFilterID() {
		 RequestSpecification reqBody = request.given().header("accept","application/json");
		 reqBody.log().all();
		 Response response = reqBody.get("/booking?firstname="+firstNameExpected);
		response.prettyPrint();		
		getBookingIdFilter_Pojo[] getRes = response.getBody().as(getBookingIdFilter_Pojo[].class);
		System.out.println(getRes.length);
		int count=0;
		for (int i = 0; i < getRes.length; i++) {
			if(getRes[i].getbookingid()==bookingId) {
				System.out.println("booking id present: ----------->"+getRes[i].getbookingid());
				count++;
			}
		}
		//if(count==0) Assert.fail("booking id not avialble in the filter");
		response.then().assertThat().statusCode(200);
	}

	//@Test(priority = 7)
	@Test(priority = 7,dependsOnMethods ="mandatoryHomeWork.mentorHomeWork.api.Pojo.Tc_PojoChaining.updateBooking")
	public void deleteBooking() {
		RequestSpecification deleteRequest = request
				.given()
				.header("Accept","application/json")
				.header("Cookie", "token="+tokenValue);
		deleteRequest.log().all();
		Response deleteResponseBody = deleteRequest.delete("/booking/"+bookingId);
		deleteResponseBody.prettyPrint();
		//Delete_Deserialize_Pojo deletePojoRes = deleteResponseBody.getBody().as(Delete_Deserialize_Pojo.class);
		//String responseMessage = deletePojoRes.getMessage();
		Assert.assertEquals(deleteResponseBody.asString(), "Created");
		deleteResponseBody.then().assertThat().statusCode(201);
	}

	
	@Test(priority = 8,dependsOnMethods ="mandatoryHomeWork.mentorHomeWork.api.Pojo.Tc_PojoChaining.deleteBooking")
	public void verifyDeleteBooking() {	
		Response response = request.given().header("accept","application/json").basePath("/booking/"+bookingId).get();
		response.prettyPrint();
		response.then().assertThat().statusCode(404);
	}
	
	
}
