package Serialization_Deserialization;

import org.testng.annotations.Test;

import Pojo.GetListUserResponseBody;
import Pojo.GetListUser_Data;
import Pojo.GetListUser_Support;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.List;

public class Get_ListUser 
{
	@Test
	public void GetListUser()
	{
		RestAssured.baseURI="https://reqres.in";
		
    GetListUserResponseBody RespBody= given()
		                    
		                    .when()
		                    
		                    .get("/api/users?page=2")
		                    
		                    .then()
		                    
		                    .log().all()
		                    
		                    .extract()
		                    
		                    .response()
		                    
		                    .as(GetListUserResponseBody.class);
    
    int total_pages = RespBody.getTotal_pages();
    
    System.out.println(total_pages);
    
    GetListUser_Support support = RespBody.getSupport();
    
    String url = support.getUrl();
    
    System.out.println(url);
    
    List<GetListUser_Data> data = RespBody.getData();
    
    GetListUser_Data first = data.get(0);
    
    String first_email = first.getEmail();
    
    System.out.println(first_email);
    
     GetListUser_Data third = data.get(2);
     
     int third_id = third.getId();
     
     System.out.println(third_id);
    
    
	}

}
