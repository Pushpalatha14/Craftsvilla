package test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Practice1{
	@Test(dependsOnMethods="display4")
	public void display1()
	{
		Reporter.log("it is executing first",true);
	}
	@Test(invocationCount=2,groups={"Regression"})
	public void display2()
	{
		Reporter.log("it is executing second",true);
	}
	@Test(priority=4,groups={"Regression"})
	public void display3()
	{
		Reporter.log("it is executing 3",true);
	}
	@Test
	public void display4()
	{
		Reporter.log("it is executing 4",true);
	}
}
