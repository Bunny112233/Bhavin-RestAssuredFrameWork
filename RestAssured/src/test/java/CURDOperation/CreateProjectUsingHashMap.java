package CURDOperation;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProectUsingHashMap()
	{
		HashMap map = new HashMap();
		map.put("createdBy", "Akash");
		map.put("projectName", "Chrome");
		map.put("status", "completed");
		map.put("teamSize", 20);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("http://localhost:8084/addProjects")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}	
}