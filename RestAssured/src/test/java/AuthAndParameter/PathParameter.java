package AuthAndParameter;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PathParameter 
{
	@Test
	public void pathParameter()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("projtId", "TY_PROJ_1002")
		
		.when().get("/projects/{projtId}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
