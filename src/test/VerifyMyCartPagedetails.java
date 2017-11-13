package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.BaseTest;
import generic.Excel;
//import generic.GenerateExtentReport;
import page.Cart;
import page.Craftsvilla_HomePage;

@Listeners(generic.Screenshot.class)
public class VerifyMyCartPagedetails extends BaseTest {
	
	@Test(groups="report")
	public void testVerifyMyCartPagedetails() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		test = extent.startTest("VerifyMyCartPagedetails");
		
		
		String cartitl = Excel.getdata(PATH, "Titles", 0, 0);
		Craftsvilla_HomePage bh=new Craftsvilla_HomePage(driver);
		bh.cartclick();
		Cart c=new Cart(driver);
		c.verifytitle(cartitl);
		c.cartmsg();
		c.verifybtn();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Passed");
	}

}
