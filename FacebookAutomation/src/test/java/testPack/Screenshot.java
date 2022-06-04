package testPack;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
//			  System.setProperty("webdriver.gecko.driver", "F:\\ram\\geckodriver.exe");
//				WebDriver driver = new FirefoxDriver();
//				driver.get("https://www.facebook.com/");
				
				String path = "F:\\ram\\Excel Data.xlsx";
				FileInputStream file = new FileInputStream(path);
//				String value = WorkbookFactory.create(file).getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
//				System.out.println(value);
//				double phone = WorkbookFactory.create(file).getSheet("sheet1").getRow(1).getCell(1).getNumericCellValue();
//				System.out.println(phone);
//				 Date date = WorkbookFactory.create(file).getSheet("sheet1").getRow(1).getCell(2).getDateCellValue();
//				System.out.println(date);
				
				Workbook workbook = WorkbookFactory.create(file);
				String value = workbook.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
				System.out.println(value);
				double phone = workbook.getSheet("sheet1").getRow(1).getCell(1).getNumericCellValue();
				long c = (long) phone;
				System.out.println(c);
				 Date date = workbook.getSheet("sheet1").getRow(1).getCell(2).getDateCellValue();
				System.out.println(date);
				
				
				
	}

}
