package mandatoryHomeWork.mentorHomeWork.api.directScript;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserCreateWithArray {

	/*
	 * 1. Requirement : To create a user in pet store
	 * 2. Endpoint : https://petstore.swagger.io/v2
	 * 3. Pathparameter: /user/createWithArray
	 * 4. authentication - Null
	 * 5. request body : [
  {
    "id": 0,
    "username": "string",
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string",
    "phone": "string",
    "userStatus": 0
  }
]

	 * 6. Status code - 200 success 
	 */
	
	
	
	
	/**
	 * @author sathish
	 * This method is direct plain rest assured script, to create a user in Swagger pet store.
	 * 
	 */
	@Test
	public void createUserSwaggerPet() {
		
		RequestSpecification requestBody = RestAssured
				.given()
				.baseUri("https://petstore.swagger.io/v2")
				.header("Content-Type","application/json")
				.body("[\r\n"
						+ "  {\r\n"
						+ "    \"id\": 0,\r\n"
						+ "    \"username\": \"string\",\r\n"
						+ "    \"firstName\": \"string\",\r\n"
						+ "    \"lastName\": \"string\",\r\n"
						+ "    \"email\": \"string\",\r\n"
						+ "    \"password\": \"string\",\r\n"
						+ "    \"phone\": \"string\",\r\n"
						+ "    \"userStatus\": 0\r\n"
						+ "  }\r\n"
						+ "]");
		
		//print the log for request body
		System.out.println("********* Printing the request log *********");
		requestBody.then().log().all();
		//build the response 
		Response postResponseBody = requestBody.post("/user/createWithArray");
		//print the log for response body
		System.out.println("********* Printing the response log *********");
		postResponseBody.then().log().all();
		System.out.println("********* Printing the request body *********");
		//pretty print 
		postResponseBody.prettyPrint();
		//asset the response code
		postResponseBody.then().statusCode(200);
		
		
	}
	
}
