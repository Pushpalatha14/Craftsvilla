package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel implements AutoConstant {
	
	public static String getdata(String PATH,String Sheet,int row,int col) throws IOException
	{
		String v="";
		try{
			FileInputStream file=new FileInputStream(PATH);
		v=WorkbookFactory.create(file).getSheet(Sheet).getRow(row).getCell(col).getStringCellValue();
				 }
			 	
		catch(Exception e)
		{
			Reporter.log("Path is invalid",true);
		}
		return v;
	}
}
