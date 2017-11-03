package generic;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GenerateExtentReport {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void startReport(){
		
		extent = new ExtentReports("./test-output/MyOwnReport.html",true);
		extent.addSystemInfo("HoastName", "Pushpa")
		.addSystemInfo("Environment", "QA")
		.addSystemInfo("User Name", "Pushpalatha");
		
		extent.loadConfig(new File("./extent-config.xml"));
		
		
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	
}
