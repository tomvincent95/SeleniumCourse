package SeleniumPlus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelUtility {

	
	public static Object[][] TestExcel(){
		Object[][] obj= null;
		try {
			InputStream is= new FileInputStream("src/test/resources/TestData/Test.xlsx");
			XSSFWorkbook book=new XSSFWorkbook(is);
			XSSFSheet sheet= book.getSheet("Sheet1");
			for(int i=1;i<=sheet.getLastRowNum();i++){
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++)
				
				System.out.print(sheet.getRow(i).getCell(j)+"\t");
				System.out.println("");
			}
			
			book.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return obj;
		
	}
}
