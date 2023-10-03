package BasicRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class demo 
{
	@Test
	public void get()
	{
		RestAssured.baseURI="https://reqres.in";
		
		          Response resp = given()
		                    
		                    .when()
		                    
		                    .get("/api/users?page=2")
		                    
		                    .then()
		                    
		                    .extract()
		                    
		                    .response();
		          
		          JsonPath jp = resp.jsonPath();
		          
		           jp.getString("data[2].first_name");        
		                  
		                     
	}

}
