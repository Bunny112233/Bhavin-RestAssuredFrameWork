package AuthAndParameter;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Oauth2 
{
	@Test
	public void auth2auth()
	{
		Response res = given()
		.formParam("client_id","SDET_21")
		.formParam("client_secret","6f5a3efd583d6a80d75253543abfe736")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code","authorization_code")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		res.then().log().all();
	
		String Token=res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//create a new request to access the token
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID", "2405")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
	}
}

