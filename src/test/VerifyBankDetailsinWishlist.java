package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.WhishListPage;
import page.WishLIst_Login_Page;
import page.WishList_BankDetails_Page;

@Listeners(generic.Screenshot.class)
public class VerifyBankDetailsinWishlist extends BaseTest {
	
	@Test(priority=6)
	public void testVerifyBankDetailsinWishlist() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String emailID = Excel.getdata(PATH, "wishlist", 0, 0);
		String pwd = Excel.getdata(PATH, "wishlist", 0, 1);
		String holder = Excel.getdata(PATH, "BankAcc", 0, 0);
		String number = Excel.getdata(PATH, "BankAcc", 0, 1);
		String Renumber = Excel.getdata(PATH, "BankAcc", 0, 2);
		String ifsc = Excel.getdata(PATH, "BankAcc", 0, 3);
		
		WhishListPage wp=new WhishListPage(driver);
		
		wp.clickwishlist();
		WishLIst_Login_Page wlp= new WishLIst_Login_Page(driver);
		wlp.enterEmail(emailID);
		wlp.clickcontbtn();
		wlp.enterPwd(pwd);
		wlp.clicklogin();
		wlp.clickname();
		Thread.sleep(3000);
		wlp.clickwish();
		WishList_BankDetails_Page wbp=new WishList_BankDetails_Page(driver);
		
		wbp.clickBankDetails();
		wbp.verifyBankAccHolder();
		wbp.verifyBankAccNumber();
		wbp.verifyRe_enterAccNumber();
		wbp.verifyIFSC();
		wbp.verifysavebtn();
		Thread.sleep(1000);
		
		
		
	}

}
