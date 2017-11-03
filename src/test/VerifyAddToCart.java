package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.Cart;
import page.Craftsvilla_HomePage;
import page.Product_Selection_Page;
import page.Product_Spec_page;
import generic.GenericUtils;

@Listeners(generic.Screenshot.class)
public class VerifyAddToCart extends BaseTest{

	@Test(priority=2)
	public void  testAddToCart() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		
		//String num= Excel.getdata(PATH,"Sheet1",0,0);
		
		Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
		bh.selectoption();
		Thread.sleep(2000);
		bh.selectsuboption();
		
		Product_Selection_Page pg=new Product_Selection_Page(driver);
		
		
		pg.clickitem();
		Thread.sleep(2000);
		
		Product_Spec_page ps= new Product_Spec_page(driver);
		Thread.sleep(2000);
		String text1 = ps.itemtext();
		
		ps.cart();
		
		Cart c=new Cart(driver);
		
		String text2 = c.itemtext();
		Thread.sleep(2000);
		GenericUtils.verify(text1, text2);
		Thread.sleep(1000);
	
	
		
	}
}
