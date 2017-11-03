package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;
import generic.BaseTest;

public class Craftsvilla_HomePage extends BasePage {
	
	
	@FindBy(xpath="//a[.='CRAFTSVILLA BRANDS']")
	private WebElement option;
	
	@FindBy(xpath="//a[.='Craftsvilla Embroidered Sarees']")
	private WebElement suboption;
	
	@FindBy(xpath="//span[.='Cart ']")
	private WebElement cart;
	
	public Craftsvilla_HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectoption()
	{
		mouserover(driver,option);
	}
	
	public void selectsuboption()
	{
		suboption.click();
	}
	
	public void cartclick()
	{
		cart.click();
	}

}
