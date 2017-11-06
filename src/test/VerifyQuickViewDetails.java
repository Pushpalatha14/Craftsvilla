package test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.GenericUtils;
import page.Craftsvilla_HomePage;
import page.Product_Selection_Page;
import page.Product_Spec_page;
import page.QuickView;

@Listeners(generic.Screenshot.class)
public class VerifyQuickViewDetails  extends BaseTest {
	
	@Test(priority=5)
	public void testVerifyQuickViewDetails() throws InterruptedException
	{
		test=extent.startTest("testVerifyQuickViewDetails");
		
		Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
		bh.selectoption();
		Thread.sleep(2000);
		bh.selectsuboption();
		
		Product_Selection_Page pg=new Product_Selection_Page(driver);
		QuickView qv=new QuickView(driver);
	
		
		qv.clickQV();
		Thread.sleep(2000);
		String det2 =qv.Qgetdetails();
		Thread.sleep(2000);
		String sold2 =qv.QgetsoldBy();
	
		//String price2 =qv.Qgetprice();
		
		qv.close();
		Thread.sleep(2000);
		
		pg.clickitem();
		
		Product_Spec_page ps=new Product_Spec_page(driver);
		Thread.sleep(3000);
		String det1 = ps.getdetails();
	
		String sold1 = ps.getsoldBy();
		
		//String price1 = pg.getprice();
		//Thread.sleep(2000);
		
		GenericUtils.compare(det1, det2);
		Thread.sleep(2000);
		GenericUtils.compare(sold1, sold2);
		Thread.sleep(1000);
		//GenericUtils.verify(price1, price2);
	}

}
