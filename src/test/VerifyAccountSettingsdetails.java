package test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.AccountSettings_WishlistPage;
import page.WhishListPage;
import page.WishLIst_Login_Page;

@Listeners(generic.Screenshot.class)
public class VerifyAccountSettingsdetails extends BaseTest {
	
	@Test(priority=9)
	public void testVerifyAccountSettingsdetails() throws IOException, InterruptedException
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
		AccountSettings_WishlistPage ac=new AccountSettings_WishlistPage(driver);
		
		ac.clickaccsettings();
		ac.clickedit();
		ac.verifyFirstname();
		ac.verifylastname();
		ac.verifyDOB();
		ac.verifyMaleradiobtn();
		ac.verifyFeMaleradiobtn();
		ac.verifysave_cancelbtn();
		Thread.sleep(1000);
	}

}
