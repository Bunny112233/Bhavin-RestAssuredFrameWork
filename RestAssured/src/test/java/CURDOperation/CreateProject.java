package CURDOperation;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class CreateProject 
{
	@Test
	public void createProject()
	{
		//create the json data before request
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Bhavin");
		jobj.put("projectName", "Google");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 20);
		
		//set the request specification before request
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//Send the request
		Response res = req.post("http://localhost:8084/addProject");
		res.then().assertThat().statusCode(201);
		
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
	}
}
