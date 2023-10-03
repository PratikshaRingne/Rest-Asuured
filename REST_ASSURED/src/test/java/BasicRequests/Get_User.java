package BasicRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_User 
{
	@Test (enabled=false)
	public void PostUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		     Response resp = given()
		                   
		                   .body("{\r\n" + 
		                   		"    \"name\": \"Prachi\",\r\n" + 
		                   		"    \"job\": \"Test Engineer\"\r\n" + 
		                   		"}")
		                   
		                   .header("Content-Type","application/json")
		                   
		                   .when()
		                   
		                   .log().all()
		                   
		                   .post("/api/users/")
		                   
		                   .then()
		                   
		                   .log().all()
		                   
		                   .extract()
		                   
		                   .response();
		     
		     System.out.println(resp.asPrettyString()); 
		     
		     
		     JsonPath jp = resp.jsonPath();
		     
		     System.out.println("________________");
		                  
	}
	
	 
	
	@Test
	public void GetPra()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		     Response resp = given()
		                   
		                   .when()
		                    
		                   .get("/api/users/3")
		                   
		                   .then()
		                  
		                   .extract()
		                   
		                   .response();
		      
		     System.out.println(resp.asPrettyString());
		                   
	}

}
