package test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.WhishListPage;
import page.WishLIst_Login_Page;
import page.WishList_BankDetails_Page;

@Listeners(generic.Screenshot.class)
public class VerifysaveddetailsareRemoved_Wishlist extends BaseTest {
	
	@Test(priority=8)
	public void testVerifysaveddetailsareRemoved_Wishlist() throws IOException, InterruptedException
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
		WishList_BankDetails_Page wbp=new WishList_BankDetails_Page(driver);
		wbp.clickBankDetails();
		wbp.verifysaveddetails();
		wbp.clickremove();
		wbp.javascriptpopup();
		Thread.sleep(1000);
	}

}
