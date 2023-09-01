package mandatoryHomeWork.mentorHomeWork.api.pojo;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass.AuthBodyResponse;

public class BaseClass {
	public static String tokenValue;
	public static int bookingId;
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
}
