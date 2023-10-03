package BasicRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_CreateUser 
{
	@Test
	public void CreateUser()
	{
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"testusertwo\",\r\n"
				+ "  \"firstName\": \"Jan\",\r\n"
				+ "  \"lastName\": \"Batch\",\r\n"
				+ "  \"email\": \"jan.batch@velocity.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543212\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
		
		String StrBody = response.asPrettyString();
		
		System.out.println(StrBody);
		                    
	}
	
	@Test
	public void GetCreatedUser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		     Response resp = given()
		                    
		                    .when()
		                    
		                    .get("/user/testusertwo")
		                    
		                    .then()
		                    
		                    .extract()
		                    
		                    .response();
		    
		     String StrBody = resp.asPrettyString();
		     
		     System.out.println(StrBody);
	}

}
