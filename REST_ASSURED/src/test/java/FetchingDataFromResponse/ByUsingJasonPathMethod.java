package FetchingDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ByUsingJasonPathMethod 
{
	@Test
	public void GetUser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
	        Response resp = given()
		                   
		                   .when()
		                   
		                   .get("/user/testusertwo")
		                   
		                   .then()
		                   
		                   .extract()
		                   
		                   .response();
	        
	         String body =resp.asPrettyString();
	        
	        JsonPath jp = resp.jsonPath();
	        
	        String firstname = jp.getString("firstName");
	        
	        System.out.println("firstname="+firstname);
	        
	        System.out.println(jp.getString("password"));
	        
	         
	}

}
