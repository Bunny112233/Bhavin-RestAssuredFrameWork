package genericUtils;
import java.util.Random;

public class JavaUtility 
{
	public int getrandomNum() 
	{
		Random r = new Random();
		int randomNum = r.nextInt(1000);
		return randomNum;
	}
	/*
	   public static void main(String[] args) 
	   {
		JavaUtility j = new JavaUtility();
		
		System.out.println(j.getrandomNum());
		}
	*/
}
