package genericUtils;

import io.restassured.response.Response;

public class RestAssuredUtility 
{
	public String getJsonData(Response res,String jsonPath)
	{
		String value = res.jsonPath().get(jsonPath);
		return value;
	}
}
