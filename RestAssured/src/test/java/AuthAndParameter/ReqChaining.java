package AuthAndParameter;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import POJO.ProjectLiabrary;
import genericUtils.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqChaining 
{
	@Test
	public void reqChaining()
	{
		JavaUtility j = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLiabrary p = new ProjectLiabrary("Modi","google"+j.getrandomNum(),"done",20);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("/addProject");
		
		String myProjID = res.jsonPath().get("projectID");
		System.out.println(myProjID);
		
		res.then().log().all();
		
		given()
		.pathParam("projID",myProjID)
		
		.when()
		.get("/projects/{projID}")
		.then().assertThat().statusCode(200).log().all();
	}
}
