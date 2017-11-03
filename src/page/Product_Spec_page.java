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

public class Product_Spec_page extends BasePage {
	
	

	@FindBy(xpath="//h1[@itemprop='name']")
	private WebElement name;
	
	@FindBys({@FindBy(xpath="(//b[.='Details:']/../..//li)[position()<last()]")})
	private List<WebElement> details;
	
	@FindBys({@FindBy(xpath="(//b[.='Sold by:']/../..//span)[position()<last()-3]")})
	private List<WebElement> soldBy;
	

	@FindBys({@FindBy(xpath="//b[.='Price:']/../..//span[@class='pdp-offer-price']")})
	private List<WebElement> price;
	
	@FindBy(xpath="//span[contains(text(),'Available for Cash on Delivery')]")
	private WebElement codtxt;
	
	@FindBy(xpath="//span[.='Add to Cart']")
	private WebElement tocart;
	
	@FindBy(id="buynow")
	private WebElement buy;
	
	@FindBy(xpath="//a[.='+ More']")
	private WebElement more;
	
	@FindBy(xpath="//a[.='Product Specification']")
	private WebElement prodspec;
	
	@FindBy(xpath="//a[.='Similar Products']")
	private WebElement similar;
	
	@FindBy(xpath="//a[.='Customer who bought this item also bought']")
	private WebElement smiprods;
	
	public Product_Spec_page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String itemtext()
	{
		String et = name.getText();
		return et;
	}
	
	public String getdetails()
	{
		String str="";
		for(int i=0;i<details.size();i++)
		{
			
			String ele = details.get(i).getText();
			
			str=str+ele;
			
			
		}
		return str;
		
	}
	public String getsoldBy()
	{
		String str="";
		for(int i=0;i<soldBy.size();i++)
		{
			
			String ele = soldBy.get(i).getText();
			
			str=str+ele;
			
			
		}
		return str;
		
	}
	public String getprice()
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
	
	public String verifycodtext()
	{
		String actual = codtxt.getText();
		return actual;
	}

	public void cart()
	 {
		verifyElementIsPresent(tocart);
		tocart.click();
		
	 }
	 
	public void buynow()
	 {
		 buy.click();
	 }
	
	public void clickmore()
	{
		verifyElementIsPresent(more);
		more.click();
	
	}
	public void verifyprodspec()
	{
		verifyElementIsPresent(prodspec);
		if(prodspec.isDisplayed())
		{
			Reporter.log("Product Specification section is displayed",true);
		}
		else
		{
			Reporter.log("Product Specification section is not displayed",true);
			Assert.fail();
		}
	}
	public void similar()
	{
		verifyElementIsPresent(similar);
		similar.click();
	}
		
	
	public void verifysimilar()
	{
		verifyElementIsPresent(smiprods);
		if(smiprods.isDisplayed())
		{
			Reporter.log("Customer who bought this item also bought section is displayed",true);
		}
		else
		{
			Reporter.log("Customer who bought this item also bought is not displayed",true);
			Assert.fail();
		}
		}
	}
	

