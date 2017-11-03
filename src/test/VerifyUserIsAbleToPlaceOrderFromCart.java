package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.Cart;
import page.Craftsvilla_HomePage;
import page.Product_Selection_Page;
import page.Product_Spec_page;
import page.Shipping_Payment_Page;

@Listeners(generic.Screenshot.class)
public class VerifyUserIsAbleToPlaceOrderFromCart extends BaseTest{
	
	@Test(priority=11)
	public void testVerifyUserIsAbleToPlaceOrderFromCart() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String emailID = 	Excel.getdata(PATH, "Shipping", 0, 0);
		String firstname = 	Excel.getdata(PATH, "Shipping", 0, 1);
		String lastname = 	Excel.getdata(PATH, "Shipping", 0, 2);
		String pincode = 	Excel.getdata(PATH, "Shipping", 0, 3);
		String address = 	Excel.getdata(PATH, "Shipping", 0, 4);
		String mobile = 	Excel.getdata(PATH, "Shipping", 0, 5);
		
		Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
		bh.selectoption();
		Thread.sleep(2000);
		bh.selectsuboption();
		
		Product_Selection_Page pg=new Product_Selection_Page(driver);
		
		
		pg.clickitem();
		Thread.sleep(2000);
		
		Product_Spec_page ps= new Product_Spec_page(driver);
		ps.cart();
		
		Cart c=new Cart(driver);
		c.clickorderbtn();
		
		Shipping_Payment_Page sp=new Shipping_Payment_Page(driver);
		sp.enterEmail(emailID);
		sp.enterFirstname(firstname);
		sp.enterLastname(lastname);
		sp.enterpincode(pincode);
		Thread.sleep(2000);
		sp.enterAddress(address);
		sp.enterMobileNo(mobile);
		sp.clickdeliverybtn();
		sp.verifyorder();
		Thread.sleep(1000);
	}
	

}
