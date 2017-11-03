package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class AccountSettings_WishlistPage extends BasePage {

	@FindBy(xpath="//a[.='Account Settings']")
	private WebElement accsettings;
	
	@FindBys({@FindBy(xpath="//h5/..")})
	private List<WebElement> details;
	
	@FindBy(xpath="//h5")
	private WebElement name;
	
	@FindBy(xpath="//img[@id='changePersonalinfo']")
	private WebElement edit;
	
	@FindBy(xpath="//label[.='First name']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='First name']")
	private WebElement FN;
	
	@FindBy(xpath="//label[.='Last Name']")
	private WebElement lastname;
	
	@FindBy(xpath="(//input[@placeholder='Last Name'])[2]")
	private WebElement LN;
	
	@FindBy(xpath="//label[.='Date of Birth']")
	private WebElement Dateofbirth;
	
	@FindBy(xpath="//input[@placeholder='yy-mm-dd']")
	private WebElement DOB;
	
	@FindBy(xpath="//label[contains(.,'Male')]")
	private WebElement Male;
	
	@FindBy(xpath="//label[contains(.,'Female')]")
	private WebElement feMale;
	
	@FindBy(xpath="//button[.='SAVE']")
	private WebElement save;
	
	@FindBy(xpath="//div[.='CANCEL']")
	private WebElement cancel;
	
	public AccountSettings_WishlistPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickaccsettings()
	{
		verifyElementIsPresent(accsettings);
		accsettings.click();
	}
	
//	public void detailstext()
//	{
//		String str="";
//		for(int i=0;i<details.size();i++)
//		{
//			String text=details.get(i).getText();
//			str=str+text;
//			Reporter.log(str,true);
//		}
//		
//	}
	
	public void compareFN()
	{
		Reporter.log(name.getText(),true);
		String text2=name.getText();
		String[] str = text2.split(" ");
		String text1 = FN.getAttribute("value");
		if(str[0].equals(text1))
		{
			Reporter.log("First Name is "+str[0],true);
		}
		else
		{
			Reporter.log("Values are not matching",true);
			Assert.fail();
		}
	}
	
	public void compareLN()
	{
		
		String text2=name.getText();
		String[] str = text2.split(" ");
		String text1 = LN.getAttribute("value");
		if(str[1].equals(text1))
		{
			Reporter.log("Last Name is "+str[1],true);
		}
		else
		{
			Reporter.log("Values are not matching",true);
			Assert.fail();
		}
	}
	
	public void compare_emailid(String value)
	{
		String text1 = details.get(details.size()-1).getText();
		String[] str = text1.split(" ");
		String text2 = str[str.length-1];
		if(text2.contains(value))
		{
			Reporter.log("Emailid is matching with the login emailid "+value,true);
		}
		else
		{
			Reporter.log("Emailid is not matching with the login emailid "+value,true);
			Assert.fail();
		}
	}

	public void clickedit()
	{
		verifyElementIsPresent(edit);
		edit.click();
	}
	public void values()
	{
		
		String text1 = FN.getAttribute("value");
		Reporter.log(text1,true);
	}
	
	public void verifyFirstname()
	{
		verifyElementIsPresent(firstname);
		verifyElementIsPresent(FN);
		if(firstname.isDisplayed()&&FN.isDisplayed())
		{
			Reporter.log("FirstName text box is displayed",true);
		}
		else
		{
			Reporter.log("FirstName text box is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifylastname()
	{
		verifyElementIsPresent(lastname);
		if(lastname.isDisplayed()&&LN.isDisplayed())
		{
			Reporter.log("LastName text box is displayed",true);
		}
		else
		{
			Reporter.log("LastName text box is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyDOB()
	{
		verifyElementIsPresent(Dateofbirth);
		if(Dateofbirth.isDisplayed()&&DOB.isDisplayed())
		{
			Reporter.log("Dateofbirth text box is displayed",true);
		}
		else
		{
			Reporter.log("Dateofbirth text box is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyMaleradiobtn()
	{
		if(Male.isDisplayed())
		{
			Reporter.log("Male radio button is displayed",true);
		}
		else
		{
			Reporter.log("Male radio button is not displayed",true);
			Assert.fail();
		}
	}
	public void verifyFeMaleradiobtn()
	{
		if(feMale.isDisplayed())
		{
			Reporter.log("FeMale radio button is displayed",true);
		}
		else
		{
			Reporter.log("FeMale radio button is not displayed",true);
			Assert.fail();
		}
	}
	public void verifysave_cancelbtn()
	{
		if(save.isDisplayed()&&cancel.isDisplayed())
		{
			Reporter.log("Save and Cancel buttons are displayed",true);
		}
		else
		{
			Reporter.log("Save and Cancel buttons are not displayed",true);
			Assert.fail();
		}
	}
	
}
