package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class Shipping_Payment_Page extends BasePage {
	
	

	@FindBy(id="address-email")
	private WebElement email;
	
	@FindBy(id="address-first-name")
	private WebElement FN;
	
	@FindBy(id="address-last-name")
	private WebElement LN;
	
	@FindBy(xpath="//input[@id='address-pincode']")
	private WebElement pinCode;
	
	@FindBy(id="address-textbox")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='address-mobileno']")
	private WebElement mobileNo;
	
	@FindBy(id="address-form-submit")
	private WebElement deliver;
	
	@FindBy(xpath="//button[contains(.,'PLACE ORDER')]")
	private WebElement placeorder;
	
	public Shipping_Payment_Page(WebDriver driver) {
		super(driver);
	PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailID)
	{
		verifyElementIsPresent(email);
		email.sendKeys(emailID);
	}
	
	public void enterFirstname(String firstname)
	{
		verifyElementIsPresent(FN);
		FN.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname)
	{
		verifyElementIsPresent(LN);
		LN.sendKeys(lastname);
	}
	
	public void enterpincode(String pincode)
	{
		verifyElementIsPresent(pinCode);
		pinCode.sendKeys(pincode);
	}
	
	public void enterAddress(String Address)
	{
		verifyElementIsPresent(address);
		address.sendKeys(Address);
	}
	
	public void enterMobileNo(String mobile)
	{
		verifyElementIsPresent(mobileNo);
		mobileNo.sendKeys(mobile);
	}
	
	public void clickdeliverybtn()
	{
		verifyElementIsPresent(deliver);
		deliver.click();
	}
	
	public void verifyorder()
	{
		verifyElementIsPresent(placeorder);
		if(placeorder.isEnabled())
			Reporter.log("User is able to place the order through cart");
		else
			Reporter.log("User is not able to place the order through cart");
	}

}
