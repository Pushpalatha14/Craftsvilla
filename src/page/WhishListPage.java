package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class WhishListPage extends BasePage {

	@FindBy(xpath="(//i[@class='icon cv-wishlist-icon'])[1]")
	private WebElement wishlist;
	
	@FindBy(xpath="//b[.='MY ACCOUNT']")
	private WebElement myacc;
	
	@FindBys({@FindBy(xpath="//b[.='MY ACCOUNT']/../../li")})
	private List<WebElement> myaccdetails;
	
	@FindBy(xpath="//b[.='SETTINGS']")
	private WebElement settings;
	
	@FindBy(xpath="//a[.='Account Settings']")
	private WebElement accsettings;
	
	
	public WhishListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickwishlist()
	{
		wishlist.click();
	}
	
	public void verifymyaccdetails()
	{
		verifyElementIsPresent(myacc);
		
		if(myacc.isDisplayed())
		{
		String str="";
		for(int i=0;i<myaccdetails.size();i++)
		{
			
			WebElement ele = myaccdetails.get(i);
			String text = ele.getText();
			str=str+text;
			//Reporter.log(ele,true);
			if(ele.isDisplayed())
				Reporter.log(text+" is displayed under My Account",true);
			else
				Reporter.log(text+" is not displayed under My Account",true);
		}
		
		
		}
	
	}
	public void verifysettingsdetails()
	{
		verifyElementIsPresent(settings);
		if(settings.isDisplayed())
		{
			String text = accsettings.getText();
			if(accsettings.isDisplayed())
			{
				
				Reporter.log(text+" is displayed under Settings",true);
			}
			else
			{
				Assert.fail();
				Reporter.log(text+" is not displayed under Settings",true);
			}
		}
		}
	
}
