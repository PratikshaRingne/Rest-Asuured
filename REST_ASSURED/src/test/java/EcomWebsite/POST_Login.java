package EcomWebsite;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
 

public class POST_Login extends Base_Ecom
{
	@Test
	public void Login()  
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		      Response resp = given()
		                    
		                    .header("Content-Type","application/json")
		                    
		                    .body("{\r\n" + 
		                    		"\r\n" + 
		                    		"\"userEmail\"\r\n" + 
		                    		":\"prachi1234@gmail.com\",\r\n" + 
		                    		"\"userPassword\": \"Ashvagho$h123\"\r\n" + 
		                    		"\r\n" + 
		                    		"}")
		                    
		                    .post("/api/ecom/auth/login")
		                    
		                    .then()
		                    
		                    .log().all()
		                    
		                    .extract()
		                    
		                    .response();
		      
		      
		       JsonPath jp = resp.jsonPath();
		       
		       token = jp.getString("token");
		        
		       Userid = jp.getString("UserId");
		        
		         
		        
	}

}
