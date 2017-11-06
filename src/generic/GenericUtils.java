package generic;

import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class GenericUtils {
	
	public static void compare(String s1,String s2)
	{
		Assert.assertEquals(s1, s2);
		BaseTest.test.log(LogStatus.PASS,s1+" Values are matching "+s2);
	}
	
	public static void verify(String s1,String s2)
	{
		if(s1.equalsIgnoreCase(s2))
		{
		Reporter.log(s1+" and "+s2+" Values are matching",true);
		}
		else
		{
			Assert.fail();
		}
	}
	public static void comparecontains(String s1,String s2)
	{
		if(s2.contains(s1))
		{
		BaseTest.test.log(LogStatus.PASS,s1+" and "+s2+" Values are matching");
		}
		else
		{
			Assert.fail();
		}
	}
	
	

}
