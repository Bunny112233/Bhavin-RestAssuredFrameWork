package BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetAllProjectByBDD 
{
	@Test
	public void getAllProjectByBDD()
	{
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
