package generic;

import org.testng.Assert;
import org.testng.Reporter;

public class GenericUtils {
	
	public static void compare(String s1,String s2)
	{
		Assert.assertEquals(s1, s2);
		Reporter.log(s1+" Values are matching "+s2,true);
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
		Reporter.log(s1+" and "+s2+" Values are matching",true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	

}
