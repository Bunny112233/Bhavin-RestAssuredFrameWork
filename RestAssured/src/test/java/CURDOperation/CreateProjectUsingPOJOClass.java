package CURDOperation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import POJO.ProjectLiabrary;
import genericUtils.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectUsingPOJOClass 
{
	@Test
	public void createProjerctUsingPOJO()
	{
		JavaUtility jLib = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLiabrary pLib = new ProjectLiabrary("Bhavin", "Byjus "+jLib.getrandomNum(), "Completed", 20);
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
