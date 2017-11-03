package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import generic.BasePage;
//import generic.GenericUtils;

public class Product_Selection_Page extends BasePage{
	
	@FindBy(xpath="(//img[@class='product-image lazy-onload'])[1]")
	private WebElement item;
	
	@FindBy(id="showcodlabel")
	private WebElement CODcb;
	
	public Product_Selection_Page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	 public void clickitem()
	 {
		 verifyElementIsPresent(item);
		 item.click();
	 }
	 
	public void clickcb()
	{
		CODcb.click();
	}
	
	
	
	
	

}
