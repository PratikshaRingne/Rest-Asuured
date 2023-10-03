package FetchingDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class AllTitles
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
		
		JsonPath jp = new JsonPath(jason);
		 
		String RPACopies = jp.getString("courses[2].copies");
		System.out.println(RPACopies);
		 
		int CoursesAvail = jp.getInt("courses.Size");
		 
		for( int i=0;i<CoursesAvail;i++)
		{
			 
			String Title = jp.getString("courses["+i+"].title");
			String Price = jp.getString("courses["+i+"].price");
			System.out.println( Title+":"+Price);
			 
		}
		
	}

}
