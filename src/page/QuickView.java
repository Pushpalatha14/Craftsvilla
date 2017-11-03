package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class QuickView extends BasePage{
	
	

	@FindBy(xpath="(//a[.='Quick View'])[1]")
	private WebElement quickview;
	
	@FindBys({@FindBy(xpath="(//b[.='Details:']/../..//li)")})
	private List<WebElement> details;
	
	@FindBys({@FindBy(xpath="(//b[.='Sold by:']/../..//span)[position()<last()-3]")})
	private List<WebElement> soldby;
	
	@FindBys({@FindBy(xpath="//b[.='Price:']/../..//span[@class='pdp-offer-price']")})
	private List<WebElement> price;
	
	@FindBy(xpath="//span[@class='icon quick-view-close']")
	private WebElement close;
	
	
	public QuickView(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickQV()
	{
		mouserover(driver, quickview);
		verifyElementIsPresent(quickview);
		
		quickview.click();
	}
	
	public String Qgetdetails()
	{
		String str="";
		for(int i=0;i<details.size();i++)
		{
			
			String ele = details.get(i).getText();
			str=str+ele;
			//Reporter.log(ele,true);
			
		}
		return str;
		
	}
	public String QgetsoldBy()
	{
		String str="";
		for(int i=0;i<soldby.size();i++)
		{
			
			String ele = soldby.get(i).getText();
			str=str+ele;
			//Reporter.log(str,true);
			
		}
		return str;
		
	}
	public String Qgetprice()
	{
		String str="";
		for(int i=0;i<price.size();i++)
		{
			
			String ele = price.get(i).getText();
			str=str+ele;
			Reporter.log(str,true);
			
		}
		return str;
	}
	
	public void close(){
		verifyElementIsPresent(close);
		close.click();
	}

}
