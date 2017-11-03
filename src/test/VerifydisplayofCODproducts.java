package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import page.Craftsvilla_HomePage;
import page.Product_Selection_Page;
import page.Product_Spec_page;

@Listeners(generic.Screenshot.class)
public class VerifydisplayofCODproducts extends BaseTest {
	
	@Test(priority=14)
	public void testVerifydisplayofCODproducts() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String expected = Excel.getdata(PATH, "verifycod", 0, 0);
		String expected1 = Excel.getdata(PATH, "verifycod", 0, 1);
		Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
		bh.selectoption();
		Thread.sleep(2000);
		bh.selectsuboption();
		
		Product_Selection_Page pg=new Product_Selection_Page(driver);
		Thread.sleep(2000);
		pg.clickcb();
		Thread.sleep(2000);
		String actual = pg.getUrl();
		
		//String expected="cod";
		
		GenericUtils.comparecontains(expected, actual);
		Thread.sleep(2000);
		pg.clickitem();
		Thread.sleep(2000);
		
		Product_Spec_page ps=new Product_Spec_page(driver);
		String actual1 = ps.verifycodtext();
		
		//String expected1="Available for Cash on Delivery";
		GenericUtils.verify(expected1, actual1);
		Thread.sleep(1000);
		
	}

}
