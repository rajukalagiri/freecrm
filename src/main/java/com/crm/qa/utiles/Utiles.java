package com.crm.qa.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class Utiles extends TestBase {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public Utiles() {
		super();
	}
	

	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
		
	}
	public static Object[][] getTestData(String sheetname)
	{
		try {
			FileInputStream fis =new FileInputStream("src\\main\\java\\com\\crm\\qa\\testdata\\freecrmcontacts.xlsx");
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();	
			}
		}
		return data;
		
	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}

}
