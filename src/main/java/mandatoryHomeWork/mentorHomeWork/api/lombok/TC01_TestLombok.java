package mandatoryHomeWork.mentorHomeWork.api.lombok;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import mandatoryHomeWork.mentorHomeWork.api.lombok.createBookingRequest.BookingDates;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingReq;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.CreateBookingRes;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.bookingdates;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.getBookingIdFilter_Pojo;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.updateResBody;
@Slf4j
public class TC01_TestLombok {

	public static String tokenValue;
	public static String bookingId;
	public static String firstNameExpected;
	
	public static String lastNameExpected;
	
	public static String additionalNeedsExpected;
	
	static RequestSpecification request = null;
	@BeforeMethod
	public void setUp() {
		 request = RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.headers("Content-Type", "application/json");
		 
	}
	
	@Test
	public void pingTest() {
		Response response = request.get("booking");
		response.then().statusCode(200);
	}
	
	@Test (dependsOnMethods = "pingTest")
	public void token() {
		log.info("token method entered");
		TokenRequest tokenBody = new TokenRequest();
		tokenBody.setUsername("admin");
		tokenBody.setPassword("password123");
		RequestSpecification requestBody = request.given().body(tokenBody);
		requestBody.log().all();
		Response responseBody = requestBody.post("auth");
		requestBody.then().statusCode(200);
		TokenResponse tokenResponsePojo = responseBody.getBody().as(TokenResponse.class);
		tokenValue = tokenResponsePojo.getToken();
		// how to print if the assertion fails in the log 
		Assert.assertNotNull(tokenValue);
		log.info("token value created "+tokenValue);
		log.info("token method completed");
		
	}
	
	@Test (dependsOnMethods = "token")
	public void createBooking() {
		createBookingRequest createRequestBody = new createBookingRequest();
		createRequestBody.setFirstname("Sathish");
		createRequestBody.setLastname("Kumaravelu");
		createRequestBody.setTotalprice("121");
		createRequestBody.setDepositpaid("true");
		BookingDates checkingDates = new BookingDates();
		checkingDates.setCheckin("2018-01-01");
		checkingDates.setCheckout("2018-01-01");
		createRequestBody.setBookingdates(checkingDates);
		createRequestBody.setAdditionalneeds("extra bed");
		RequestSpecification requestBody = request.given().body(createRequestBody);
		 requestBody.log().everything();
		 System.out.println("----------------------------------");
		 Response responseBody = requestBody.post("booking");
			responseBody.body().prettyPrint();
			CreateBookingResponse createBookingResPojo = responseBody.getBody().as(CreateBookingResponse.class);
			bookingId = createBookingResPojo.getBookingid();
			firstNameExpected= createBookingResPojo.getBooking().getFirstname();
			lastNameExpected= createBookingResPojo.getBooking().getLastname();
			additionalNeedsExpected= createBookingResPojo.getBooking().getAdditionalneeds();
			System.out.println("Booking id -------------> :" + bookingId);
			responseBody.then().assertThat().statusCode(200);
			Assert.assertEquals(createBookingResPojo.getBooking().getFirstname(), createRequestBody.getFirstname());
			Assert.assertEquals(createBookingResPojo.getBooking().getLastname(), createRequestBody.getLastname());
			Assert.assertEquals(createBookingResPojo.getBooking().getAdditionalneeds(), createRequestBody.getAdditionalneeds());
	}
	
	

	@Test(dependsOnMethods = "createBooking")
	public void getBooking() {
		Response response = request.given().header("accept","application/json").basePath("booking/"+bookingId).get();
		response.prettyPrint();
		createBookingRequest getBookingResPojo = response.getBody().as(createBookingRequest.class);
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(firstNameExpected, getBookingResPojo.getFirstname());
		Assert.assertEquals(lastNameExpected, getBookingResPojo.getLastname());
		Assert.assertEquals(additionalNeedsExpected, getBookingResPojo.getAdditionalneeds());
	}
	
	@Test(dependsOnMethods = "createBooking")
	public void updateBooking() {
		createBookingRequest updateBookingBody = new createBookingRequest();
		updateBookingBody.setFirstname("Guna");
		updateBookingBody.setLastname("Kumaravelu");
		updateBookingBody.setTotalprice("121");
		updateBookingBody.setDepositpaid("true");
		BookingDates checkingDates = new BookingDates();
		checkingDates.setCheckin("2018-01-01");
		checkingDates.setCheckout("2018-01-01");
		updateBookingBody.setBookingdates(checkingDates);
		updateBookingBody.setAdditionalneeds("extra bed");	
				RequestSpecification requestBody = request.given()
				   .header("Accept","application/json")
				   .header("Cookie","token="+tokenValue)
				   .body(updateBookingBody);
		requestBody.log().all();
		System.out.println("-----------Response Body--------------");
		Response responseBody = requestBody.put("/booking/"+bookingId);
		responseBody.prettyPrint();
		UpdateResponse updateBookingResponse = responseBody.getBody().as(UpdateResponse.class);
		responseBody.then().assertThat().statusCode(200);
		Assert.assertEquals(updateBookingResponse.getBooking().getFirstname(), updateBookingBody.getFirstname());
	}
	@Test(dependsOnMethods = "createBooking")
	public void getBookingFilterID() {
		 RequestSpecification reqBody = request.given().header("accept","application/json");
		 reqBody.log().all();
		 Response response = reqBody.get("/booking?firstname="+firstNameExpected);
		response.prettyPrint();		
		FilterRequest[] getRes = response.getBody().as(FilterRequest[].class);
		System.out.println(getRes.length);
		int count=0;
		for (int i = 0; i < getRes.length; i++) {
			if(getRes[i].getBookingid()==bookingId) {
				System.out.println("booking id present: ----------->"+getRes[i].getBookingid());
				count++;
			}
		}
		response.then().assertThat().statusCode(200);
	}

	@Test(dependsOnMethods = "createBooking")
	public void deleteBooking() {
		RequestSpecification deleteRequest = request
				.given()
				.header("Accept","application/json")
				.header("Cookie", "token="+tokenValue);
		deleteRequest.log().all();
		Response deleteResponseBody = deleteRequest.delete("/booking/"+bookingId);
		deleteResponseBody.prettyPrint();
		Assert.assertEquals(deleteResponseBody.asString(), "Created");
		deleteResponseBody.then().assertThat().statusCode(201);
	}

	@Test(dependsOnMethods = "deleteBooking")
	public void verifyDeleteBooking() {	
		Response response = request.given().header("accept","application/json").basePath("/booking/"+bookingId).get();
		response.prettyPrint();
		response.then().assertThat().statusCode(404);
	}
}
