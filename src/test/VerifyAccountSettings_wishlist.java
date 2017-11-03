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
public class VerifyAccountSettings_wishlist extends BaseTest{
	
	@Test(priority=10)
	public void testVerifyAccountSettings_wishlist() throws IOException, InterruptedException
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
		//ac.detailstext();
		ac.clickedit();
		Thread.sleep(2000);
		ac.compareFN();
		ac.compareLN();
		ac.compare_emailid(emailID);
		Thread.sleep(1000);
	}

}
