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

@Listeners(generic.Screenshot.class)
public class VerifyInvalidloginWishlist extends BaseTest {

	@Test(priority=13)
	public void testVerifyInvalidloginWishlist() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String emailID1 = Excel.getdata(PATH, "wishlist", 1, 0);
		String pwd = Excel.getdata(PATH, "wishlist", 1, 1);
		String emailID2 = Excel.getdata(PATH, "wishlist", 1, 2);
		
		WhishListPage wp=new WhishListPage(driver);
		
		wp.clickwishlist();
		WishLIst_Login_Page wlp= new WishLIst_Login_Page(driver);
		wlp.enterEmail(emailID1);
		wlp.clickcontbtn();
		wlp.verifyemailerr();
		wlp.clearEmail();
		wlp.enterEmail(emailID2);
		wlp.clickcontbtn();
		wlp.enterPwd(pwd);
		wlp.clicklogin();
		wlp.verifypwderr();
		Thread.sleep(1000);
		
	}
}
