package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib  {

	public String readPropertyData(String key) throws IOException {
		FileInputStream fis= new FileInputStream("src/test/resources/data/actitimedata1.property");
		Properties p= new Properties();
		p.load(fis);
		return (p.getProperty(key));
		
	}
	
	
	public String readExcelData(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream("src/test/resources/data/ActiTimeTestNg.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public void writeExcelData(String SheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("src/test/resources/data/ActiTimeTestNg.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(row).getCell(cell).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("src/test/resources/data/ActiTimeTestNg.xlsx");
		wb.write(fos);
		wb.close();
	}
}
