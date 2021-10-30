package genericUtils;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApi 
{
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	public DatabaseUtility dLib = new DatabaseUtility();

	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		dLib.connectToDB();
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}
}

