package com.bankingproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	public static String getdata(int i, int j) throws IOException
	{
		File file = new File("C:\\Users\\sonal\\Desktop\\");
		FileInputStream InputStream = new FileInputStream(file)	;
		
		@SuppressWarnings ("resource")
		XSSFWorkbook wb = new XSSFWorkbook(InputStream);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		XSSFRow row2 = sheet.getRow(i);
		
		XSSFCell cell = row2.getCell(j);
		
		String data = cell.getStringCellValue();
		
		return data;
		
	}

}
