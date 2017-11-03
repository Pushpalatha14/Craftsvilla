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

public class WishList_BankDetails_Page extends BasePage {

	@FindBy(xpath="(//a[.='Bank Details'])[last()]")
	private WebElement bankacc;
	
	@FindBy(xpath="//label[.='Bank Account Holder']")
	private WebElement baHolder;
	
	@FindBy(xpath="//input[@id='account_holder_add']")
	private WebElement baHoldertextbox;
	
	@FindBy(xpath="//label[.='Bank Account Number']")
	private WebElement baaccno;
	
	@FindBy(xpath="//input[@id='account_number_add']")
	private WebElement baaccnotext;
	
	@FindBy(xpath="//label[.='Re-Enter Account Number']")
	private WebElement reenterAccno;
	
	@FindBy(xpath="//input[@id='reenteraccountnumber_add']")
	private WebElement reenterAccnotext;
	
	@FindBy(xpath="//label[.='IFS Code']")
	private WebElement ifsc;
	
	@FindBy(xpath="//input[@id='ifsc_code_add']")
	private WebElement ifsctextbox;
	
	@FindBy(xpath="//button[.='SAVE']")
	private WebElement savebtn;
	
	@FindBys({@FindBy(xpath="(//h5[.='Bank Account Holder']/..//p)[position()<last()-2]")})
	private List<WebElement> details; 
	
	@FindBys({@FindBy(xpath="(//a[.='EDIT'])[1]|(//a[.='REMOVE'])[1]")})
	private List<WebElement> editremove; 
	
	@FindBy(xpath="//a[.='REMOVE']")
	private WebElement remove;
	
	public WishList_BankDetails_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickBankDetails()
	{
		verifyElementIsPresent(bankacc);
		bankacc.click();
	}
	
	
	
	public void verifyBankAccHolder()
	{
		verifyElementIsPresent(baHolder);
		verifyElementIsPresent(baHoldertextbox);
		String holder=baHolder.getText();
		if(baHolder.isDisplayed()&&baHoldertextbox.isDisplayed())
		{
		
		Reporter.log(holder+" textbox is displayed",true);
		}
		else
		{
			Assert.fail();
			Reporter.log(holder+" textbox is not displayed",true);
		}
	}
	public void enterBankAccHolder(String value)
	{
		baHoldertextbox.sendKeys(value);
	}
	
	public void verifyBankAccNumber()
	{
		verifyElementIsPresent(baaccno);
		verifyElementIsPresent(baaccnotext);
		String text=baaccno.getText();
		if(baaccno.isDisplayed()&&baaccnotext.isDisplayed())
		{
			Reporter.log(text+" textbox is displayed",true);
		
		}
		else
		{
			Reporter.log(text+" textbox is not displayed",true);
			Assert.fail();
			
		}
	}
	public void enterBankAccNumber(String value)
	{
		baaccnotext.sendKeys(value);
	}
	
	public void verifyRe_enterAccNumber()
	{
		verifyElementIsPresent(reenterAccno);
		verifyElementIsPresent(reenterAccnotext);
		String text=reenterAccno.getText();
		if(reenterAccno.isDisplayed()&&reenterAccnotext.isDisplayed())
		{
		
		Reporter.log(text+" textbox is displayed",true);
		}
		else
		{
			Reporter.log(text+" textbox is not displayed",true);
			Assert.fail();
			
		}
	}
	public void enterRe_enterAccNumber(String value)
	{
		reenterAccnotext.sendKeys(value);
	}
	
	public void verifyIFSC()
	{
		verifyElementIsPresent(ifsc);
		verifyElementIsPresent(ifsctextbox);
		String text=ifsc.getText();
		if(ifsc.isDisplayed()&&ifsctextbox.isDisplayed())
		{
		
		Reporter.log(text+" textbox is displayed",true);
		}
		else
		{
			Reporter.log(text+" textbox is not displayed",true);
			Assert.fail();
		}
	}
	public void enterIFSC(String value)
	{
		ifsctextbox.sendKeys(value);
	}
	
	
	public void verifysavebtn()
	{
		if(savebtn.isDisplayed())
		{
			Reporter.log("Save button is displayed",true);
		}
		else
		{
			Reporter.log("Save button is not displayed",true);
			Assert.fail();
		}
	}
	public void clicksave()
	{
		savebtn.click();
	}
	
	public void verifysaveddetails()
	{
		for(int i=0;i<details.size();i++)
		{
			WebElement value = details.get(i);
			String text;
			
			if(value.isDisplayed())
			{
				text=value.getText();
				Reporter.log(text,true);
			}
			else
			{
				Reporter.log("Saved bank details are not displayed",true);
				Assert.fail();
			}		
			
		}
		
	}
	
	public void verifyeditremove()
	{
		for(int i=0;i<editremove.size();i++)
		{
			WebElement value = editremove.get(i);
			String text;
			if(value.isDisplayed())
			{
				text=value.getText();
				Reporter.log(text+" button is displayed",true);
			}
			
		}
		
	}
	public void clickremove()
	{
		verifyElementIsPresent(remove);
		remove.click();
		Reporter.log("Saved Bank details are removed",true);
	}
		
	}

