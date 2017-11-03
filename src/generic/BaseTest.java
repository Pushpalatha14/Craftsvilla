package generic;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public abstract class BaseTest implements AutoConstant{
	
	//public static final WebDriver driver = null;
	public static WebDriver driver=null;
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
	
	
	
	@BeforeMethod
public void openapp()
{
	System.setProperty(KEY, VALUE);
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://www.craftsvilla.com/");
	driver.manage().window().maximize();
		 
	}
	
	@AfterMethod
	public void closeapp()
	{
		driver.quit();
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}

}
