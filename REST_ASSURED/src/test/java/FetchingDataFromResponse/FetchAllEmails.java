package FetchingDataFromResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class FetchAllEmails 
{
	@Test
	public void FetchEmail()
	{
		
		RestAssured.baseURI="https://reqres.in/";
		
		      Response resp = given()
		                    
		                    .when()
		                    
		                    .get("/api/users?page=2")
		                    
		                    .then()
		                    
		                    .log().all()
		                    
		                    .extract()
		                    
		                    .response();
		      
		      System.out.println(resp);
		      
		      //Printing last name of user whose first name is "Byron"
		      
		      JsonPath jp = resp.jsonPath();
		      
		      int dataSize = jp.getInt("data.size()");
		      
		      System.out.println(dataSize+"\n__________________");
		      
		      for(int i=0;i<dataSize;i++)
		      {
		    	  String firstname = jp.getString("data["+i+"].first_name");
		    	  
		    	  if(firstname.equals("Byron"))
		    	  {
		    		  String LastName = jp.getString("data["+i+"].last_name");  //Fields
		    		  System.out.println("Byron's Last Name:"+LastName);
		    		  
		    		  break;
		    	  }
		      }
	}
	

}
