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
public class verifyWhislistLogin extends BaseTest{
	
	@Test(priority=12)
	public void testverifyWhislistLogin() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String emailID = Excel.getdata(PATH, "wishlist", 0, 0);
		String pwd = Excel.getdata(PATH, "wishlist", 0, 1);
		
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
		Thread.sleep(3000);
		wp.verifymyaccdetails();
		wp.verifysettingsdetails();
		Thread.sleep(1000);
	}

}
