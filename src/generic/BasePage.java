package generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public abstract class BasePage {
	
	public static WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public static void verifytitle(String etitle)
	{
		try{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(etitle));
		//Reporter.log("Ttile is matching: "+etitle,true);
		GenerateExtentReport.test.log(LogStatus.PASS, "Title is matching");
	}
		catch(Exception e)
		{
			//Reporter.log("Ttile is not matching",true);
			GenerateExtentReport.test.log(LogStatus.FAIL, "Title is not matching");
			Assert.fail();
		}
	}
	
	public void verifyElementIsPresent(WebElement element)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			//Reporter.log("Element is present",true);
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present",true);
			Assert.fail();
		}
	}
	
	

	    public static void highlightElement(WebElement element) {
	        for (int i = 0; i <2; i++) {
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	            }
	        }
		
	public void byvalue(WebElement ele,String val)
	{
		Select sel= new Select(ele);
		
		sel.selectByValue(val);
	}
	
	public void byvisibletext(WebElement ele,String val)
	{
		Select sel= new Select(ele);
		sel.selectByVisibleText(val);
	}
	public void byindex(WebElement ele,String val)
	{
		Select sel= new Select(ele);
		sel.selectByVisibleText(val);
	}
	
	public void mouserover(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public String text(WebElement ele)
	{
		String ptext = ele.getText();
		Reporter.log(ptext,true);
		return ptext;
	}
	
	public String getUrl()
	{
		String actual = driver.getCurrentUrl();
		return actual;
	}
	
	public void javascriptpopup()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	
	
}
