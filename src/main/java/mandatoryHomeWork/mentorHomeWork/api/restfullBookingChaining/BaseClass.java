package mandatoryHomeWork.mentorHomeWork.api.restfullBookingChaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static String tokenValue;
	public static int bookingId;
	static RequestSpecification request = null;
	@BeforeMethod
	public void setUp() {
		 request = RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.headers("Content-Type", "application/json");

	}

}
