package Serialization_Deserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Pojo.CreateUserRequestBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create_User 
{
	@Test
	public void CreateUser()
	{
		CreateUserRequestBody RequestBody=new CreateUserRequestBody();
		RequestBody.setId(0);
		RequestBody.setUsername("Use_ kriti");
		RequestBody.setFirstName("Prakritiii");
		RequestBody.setLastName("Ringne");
		RequestBody.setEmail("pra.rin@gmail.com");
		RequestBody.setPassword("opd4234");
		RequestBody.setPhone("7454586595");
		RequestBody.setUserStatus(0);
		
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		CreateUserRequestBody Response = given()
		
		                    .body(RequestBody)
		
		                    .header("Content-Type", "application/json")
		
		                     .when()
		                     
		                     .log().all()
		
		                     .post("/user")
		
		                     .then()
		                     
		                     .log().all()
		
		                     .extract()
		
		                     .response()
		                     
		                     .as(CreateUserRequestBody.class);
		
		  
		 
		   int Status = Response.getUserStatus();
		 String firstname = RequestBody.getFirstName();
		 System.out.println(firstname);
		                    
	}

}
