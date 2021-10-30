package CURDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UpdateProject 
{
	@Test
	public void updateProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "AAA");
		jobj.put("projectName", "BBB");
		jobj.put("status", "completed");
		jobj.put("teamSize", 40);

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		Response res = req.put("http://localhost:8084/project/TY_PROJ_1203");
		res.then().assertThat().statusCode(200);
	}
}
