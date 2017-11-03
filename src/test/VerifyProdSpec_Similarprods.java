package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.Craftsvilla_HomePage;
import page.Product_Selection_Page;
import page.Product_Spec_page;

@Listeners(generic.Screenshot.class)
public class VerifyProdSpec_Similarprods extends BaseTest {
	
	@Test(priority=15)
	public void testVerifyProdSpec_Similarprods() throws InterruptedException
	{
	
	Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
	bh.selectoption();
	Thread.sleep(2000);
	bh.selectsuboption();
	
	Product_Selection_Page pg=new Product_Selection_Page(driver);
	
	
	pg.clickitem();
	Thread.sleep(2000);
	
	Product_Spec_page ps= new Product_Spec_page(driver);
	Thread.sleep(2000);
	ps.clickmore();
	ps.verifyprodspec();
	ps.similar();
	ps.verifysimilar();
	Thread.sleep(1000);
	}
}
