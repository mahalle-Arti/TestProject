package utility.Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	/*
	 * public static void screenshot(WebDriver driver) throws IOException { File src
	 * = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File dest = new
	 * File("F:\\Velocity\\Screenshot"); FileHandler.copy(src, dest); }
	 */
	
	public static String excelSheet(int r ,int c) throws EncryptedDocumentException, IOException {
		
		String path = "C:\\\\Users\\\\DELL\\\\Desktop\\\\ArtiExcelSheet.xlsx";
		
		FileInputStream f = new FileInputStream(path);
		
		String data = WorkbookFactory.create(f).getSheet("Velocity").getRow(r).getCell(c).getStringCellValue();
		
		System.out.println(data);
		return data;
	
}
}