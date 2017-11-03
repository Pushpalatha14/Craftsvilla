package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class Cart extends BasePage{
	
	@FindBy(xpath="//span[.='Cart ']")
	private WebElement cart;

	@FindBy(xpath="//p[@class='pure-u-24-24 order-details product-name ellipsis ']")
	private WebElement item;
	
	@FindBy(xpath="//div[.='Your cart is Empty']")
	private WebElement msg;
	
	@FindBy(xpath="//button[.='CONTINUE SHOPPING']")
	private WebElement contshopbtn;
	
	@FindBy(xpath="//span[.=' REMOVE']")
	private WebElement remove;
	
	@FindBy(xpath="//button[.='REMOVE ITEM']")
	private WebElement remitem;
	
	@FindBy(xpath="//button[.='MOVE TO WISHLIST']")
	private WebElement wishlistbtn;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement placeorder;
	
	@FindBy(xpath="(//h3[.='Shipping Details ']|//span[.='Payment'])")
	private WebElement shipPaymnt;
	
	public Cart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void cart()
	{
		cart.click();
	}
	public String itemtext()
	{
		verifyElementIsPresent(item);
		String at = text(item);
		highlightElement(item);
		return at;
	}
	
	public void cartmsg()
	{
		verifyElementIsPresent(msg);
		String txt=msg.getText();
		highlightElement(msg);
		if(msg.isDisplayed())
		{
		Reporter.log(txt+" : Message is displayed",true);
		}
		else
			Reporter.log("Message is not displayed");
	}
	
	public void verifybtn()
	{
		verifyElementIsPresent(contshopbtn);
		if(contshopbtn.isDisplayed())
		Reporter.log("Button is displayed",true);
		else
			Reporter.log("Button is not displayed");	
	}
	
	public void title()
	{
		driver.getTitle();
	}
	
	public void clickrem()
	{
		verifyElementIsPresent(remove);
		remove.click();
	}
	
	public void clickremitem()
	{
		verifyElementIsPresent(remitem);
		remitem.click();
	}
	
	public void checkremove()
	{
		verifyElementIsPresent(remitem);
		if(remitem.isDisplayed())
			Reporter.log("Remove Button is displayed",true);
		else
			Reporter.log("Remove Button is not displayed",true);
	}
	public void checkwishlist()
	{
		verifyElementIsPresent(remitem);
		if(wishlistbtn.isDisplayed())
			Reporter.log("WishList Button is displayed",true);
		else
			Reporter.log("Remove Button is not displayed",true);
	}
	
	public void clickorderbtn()
	{
		verifyElementIsPresent(placeorder);
		placeorder.click();
	}
	
	public void verifyshippaymnt()
	{
		verifyElementIsPresent(shipPaymnt);
		if(shipPaymnt.isDisplayed())
		Reporter.log("Shipping and Payment details are displayed",true);
		else
		Reporter.log("Shipping and Payment details are not displayed",true);	
	}
	
}
