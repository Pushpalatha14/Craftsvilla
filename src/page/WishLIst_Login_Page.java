package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class WishLIst_Login_Page extends BasePage {

	@FindBy(id="emailId")
	private WebElement emailid;
	
	@FindBy(id="continueBtn")
	private WebElement continuebt;
	
	@FindBy(id="userPassword")
	private WebElement pwd;
	
	@FindBy(id="loginCheck")
	private WebElement loginbtn;
	
	@FindBy(xpath="//span[.='Pushpalatha']")
	private WebElement id;
	
	@FindBy(xpath="(//a[.='Wishlist'])[2]")
	private WebElement wishlstoption;
	
	@FindBy(xpath="//div[.='Email Id is not valid']")
	private WebElement emailerrmsg;
	
	@FindBy(xpath="//div[@id='error-response']")
	private WebElement pwderrmsg;
	
	public WishLIst_Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void enterEmail(String emailID)
	{
		verifyElementIsPresent(emailid);
		emailid.sendKeys(emailID);
	}
	
	public void clearEmail()
	{

		emailid.clear();
	}
	
	public void clickcontbtn()
	{
		verifyElementIsPresent(continuebt);
		continuebt.click();
	}
	
	public void enterPwd(String password)
	{
		verifyElementIsPresent(pwd);
		pwd.sendKeys(password);
	}

	public void clicklogin()
	{
		verifyElementIsPresent(loginbtn);
		loginbtn.click();
	}
	
	public void clickname()
	{
		verifyElementIsPresent(id);
		mouserover(driver, id);
	}
	
	public void clickwish()
	{
		verifyElementIsPresent(wishlstoption);
		mouserover(driver, wishlstoption);
		wishlstoption.click();
	}
	public void verifyemailerr()
	{
		verifyElementIsPresent(emailerrmsg);
		if(emailerrmsg.isDisplayed())
		{
			String text = emailerrmsg.getText();
			Reporter.log(text+" message is displayed",true);
		}
		else
			Reporter.log("Error msg is not displayed",true);
	}
	
	public void verifypwderr()
	{
		verifyElementIsPresent(pwderrmsg);
		String text1 = pwderrmsg.getText();
		if(pwderrmsg.isDisplayed())
		{
			Reporter.log(text1+" message is displayed",true);
		}
		else{
			
		Assert.fail();
			Reporter.log("Error msg is not displayed",true);
		}
	}

}
