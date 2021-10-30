package EndToEndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import POJO.ProjectLiabrary;
import genericUtils.BaseApi;
import genericUtils.EndPoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectUsingDatabase extends BaseApi
{	
	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{

		//create a project through API
		ProjectLiabrary pLib = new ProjectLiabrary("Bhavin", "Chrome"+jLib.getrandomNum(), "Created", 45);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(EndPoint.addProject);
		
		res.then().log().all();
		
		//capture the expected data
		String expData = rLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		//verify it in database
		String query = "select * from project";
		String actData = dLib.getDataFromDB(query, 4, expData);
		
		//validate
		Assert.assertEquals(actData, expData);
		System.out.println("sucessful");	
	}
}



/*	@Test
public void aaaa() throws Throwable
{
	ProjectLiabrary plib = new ProjectLiabrary("asd", "ff", "finish",10);
	Response res = given()
	.contentType(ContentType.JSON)
	.body(plib)
	.when()
	.post(EndPoint.addProject);
	res.then().log().all();
	
	String expData = rLib.getJsonData(res, "projectName");
	
	System.out.println(expData);
	
	String query = "select * from project";
	String actData = dLib.getDataFromDB(query, 4, expData);
	System.out.println(actData);
}*/
