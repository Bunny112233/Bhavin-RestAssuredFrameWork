package CURDOperation;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFile 
{
	@Test
	public void createProjectUsingFile() throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("./data.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(fis)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}
}