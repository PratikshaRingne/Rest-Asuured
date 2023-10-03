package EcomWebsite;

import org.testng.annotations.Test;

import EcomWebsite.Base_Ecom;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.File;

public class POST_AddProduct extends Base_Ecom
{
	@Test
	public void AddProduct()
	{
		File file=new File("\"C:\\Users\\Pratiksha\\Desktop\\Selenium\\top.png\"");
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		                   given()
		                   
		                  .header("Authorization",token)
		                  
		                  .param("productName", "Party Wear Top")
		                  
		                  .param("productAddedBy", Userid)
		                  
		                  .param("productCategory", "fashion")
		                  
		                  .param("productSubCategory", "Fancy Top")
		                  
		                  .param("productPrice", "1200")
		                  
		                  .param("productDescription", "SilkyCotton")
		                  
		                  .param("productFor", "Female")
		                  
		                  .multiPart("productImage",file)
		                  
		                  .when()
		                  
		                  .post("api/ecom/product/add-product")
		                  
		                  .then()
		                  
		                  .extract()
		                  
		                  .response();
		                  
		                   
		                   
	}

}
