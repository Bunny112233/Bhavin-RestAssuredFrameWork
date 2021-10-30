package AuthAndParameter;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.annotations.Test;

public class BarrierToken 
{
	@Test
	public void barrierToken()
	{
		HashMap map = new HashMap();
		map.put("name","SDET-21-Repo");
		
		given()
		
		.auth()	
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		.then().log().all();
	}
}
