package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.AutoConstant;
import generic.BaseTest;
import generic.Excel;
import page.WhishListPage;
import page.WishLIst_Login_Page;

@Listeners(generic.Screenshot.class)
public class VerifyInvalidloginWishlist extends BaseTest {

	@DataProvider(name="getdata")
	public Object[][] getexceldata() throws IOException
	{
		Object[][] obj=new Object[2][2];
		for(int i=0;i<=1;i++)
		{
			for(int j=0;j<=1;j++)
			{
				obj[i][j]= Excel.getdata(AutoConstant.PATH, "Sheet6", i, j);
			}
		}
		return obj;
	}
	
	@Test(dataProvider="getdata")
	public void testVerifyInvalidloginWishlist(String un,String pwd) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
//		String emailID1 = Excel.getdata(PATH, "wishlist", 1, 0);
//		String pwd = Excel.getdata(PATH, "wishlist", 1, 1);
//		String emailID2 = Excel.getdata(PATH, "wishlist", 1, 2);
		
		
		WhishListPage wp=new WhishListPage(driver);
		
		wp.clickwishlist();
		WishLIst_Login_Page wlp= new WishLIst_Login_Page(driver);
		wlp.enterEmail(un);
		wlp.clickcontbtn();
		wlp.verifyemailerr();
		wlp.clearEmail();
		wlp.enterEmail("push14pa@gmail.com");
		wlp.clickcontbtn();
		wlp.enterPwd(pwd);
		wlp.clicklogin();
		wlp.verifypwderr();
		Thread.sleep(1000);
		
	}
}
