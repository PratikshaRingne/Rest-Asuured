package BasicRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GET_FetchUser 
{
	@Test
	public void GetUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		                     
		      Response resp = given()
		                     
		                     .when()
		                     
		                     .get("/api/users/2")
		                     
		                     .then()
		                     
		                     .extract()
		                     
		                     .response();
		       
		       String StrBody = resp.asPrettyString();
		       
		       System.out.println(StrBody);
		       
		       System.out.println("Status Code : "+resp.getStatusCode());
		       
		       System.out.println("Time : "+resp.getTime());
		
	}

}
