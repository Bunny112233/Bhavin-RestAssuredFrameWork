package genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con = null;
	ResultSet result = null;
	Driver driverRef;
	
	public void connectToDB() throws Throwable
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		Statement stat = con.createStatement();
		String value = "select * from Projects";
		result = con.createStatement().executeQuery(query);
		
		while(result.next()) 
		{	
			value = result.getString(Columnindex);
		}
		return value;
	}
	
	public String getDataFromDB(String query, int columnindex, String expData) throws Throwable
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) 
		{	
			if(result.getString(columnindex).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verified");
			return expData;
		}
	}

	public String executeQueryAndGetData(String query, int i, String expData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	Connection con ;
	ResultSet result ;
	Driver driverRef;
	
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	}
	
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	public String getDataFromDB(String query, int columnindex, String expData) throws Throwable
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) 
		{	
			if(result.getString(columnindex).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verified");
			return expData;
		}
	}*/
}
