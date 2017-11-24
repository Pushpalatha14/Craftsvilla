package generic;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseTest implements AutoConstant{
	
	//public static final WebDriver driver = null;
	public static WebDriver driver=null;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeClass(alwaysRun=true)
	public void startReport(){
		
		extent = new ExtentReports("./test-output/MyOwnReport.html",true);
		extent.addSystemInfo("Host Name", "Pushpa")
		.addSystemInfo("Environment", "QA")
		.addSystemInfo("User Name", "Pushpalatha");
		
		extent.loadConfig(new File("./extent-config.xml"));
		}	
//	@BeforeTest(alwaysRun=true)
//	@Parameters("Browser")
//	public void crossbrowser(String Browser)
//	{
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty(CHROMEKEY, CHROMEVALUE);
//			driver=new ChromeDriver();
//		}
//		else if(Browser.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty(GECKOKEY, GECKOVALUE);
//			driver=new FirefoxDriver();
//		}
////		else
////		{
////			test.log(LogStatus.FAIL, "enter correct value");
////		}
//	}
	
@BeforeMethod(alwaysRun=true)
public void openapp()
{
		System.setProperty(CHROMEKEY, CHROMEVALUE);
		driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://www.craftsvilla.com/");
	//test.log(LogStatus.PASS, "URL is enetered");
	driver.manage().window().maximize();
		 
	}
	
	@AfterMethod
	public void closeapp()
	{
		//driver.quit();
	}
	
	@AfterClass
	public void endReport()
	{
		extent.flush();
		//extent.close();
	}

}
