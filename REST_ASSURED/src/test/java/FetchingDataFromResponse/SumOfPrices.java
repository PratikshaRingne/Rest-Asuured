package FetchingDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class SumOfPrices 
{
	@Test
	public void FetchData( )
	{
		String jason="{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		JsonPath jp= new JsonPath(jason);
		
		
		int Courses = jp.getInt("courses.size()");
		
		System.out.println(Courses);
		
		
		int sum=0;
		
		for(int i=0;i<Courses;i++)
		{
			int price = jp.getInt("courses["+i+"].price");
			int copies = jp.getInt("courses["+i+"].copies");
			
			int total = price*copies;
			
			sum=sum+total;
		}
		//System.out.println(sum);
		String PAmount = jp.getString("dashboard.purchaseAmount");
		//System.out.println(PAmount);
		Assert.assertEquals(PAmount,sum);
	}

}
