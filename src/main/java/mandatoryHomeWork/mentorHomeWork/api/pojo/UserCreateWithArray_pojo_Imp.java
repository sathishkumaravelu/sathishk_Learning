package mandatoryHomeWork.mentorHomeWork.api.pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UserCreateWithArray_pojo_Imp {

	/*
	 * 1. Requirement : To create a user in pet store 2. Endpoint :
	 * https://petstore.swagger.io/v2 3. Path: /user/createWithArray 4.
	 * authentication - Null 5. request body : [ { "id": 0, "username": "string",
	 * "firstName": "string", "lastName": "string", "email": "string", "password":
	 * "string", "phone": "string", "userStatus": 0 } ]
	 * 
	 * 6. Status code - 200 success
	 */

	/**
	 * @author sathish
	 * This method is using the pojo implementation for the request body to read the value
	 *  
	 */
	@Test
	public void createUserFrom_pojoClass() {
	
		CreateUserPetStore_pojo obj = new CreateUserPetStore_pojo(0,"sathi", "Sathish", "kumaravelu", "sathish@test.com", "test", "918238971", 0);
		
		System.out.println(obj);
		
		 									RestAssured
												.given()
												.baseUri("https://petstore.swagger.io/v2")
												.contentType(ContentType.JSON)
												.accept("application/json")
												.body(obj)
												.post("/user").then().log().all();
												
												
												
												
		
		/*
		//printing the requestBody log
		System.out.println("********** Request log ************");
		//requestBody.then().log().everything(true);

		//bulding the post response
		Response postResponseBody = requestBody.post("/user/createWithArray");
		//pretty print
		System.out.println("********** Response body ************");
		postResponseBody.prettyPrint();
		//asset the response code
		postResponseBody.then().statusCode(200);*/
	}

}
