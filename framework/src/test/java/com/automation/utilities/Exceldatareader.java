package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatareader {
	XSSFWorkbook workbook;

	public Exceldatareader() throws FileNotFoundException {
		File file = new File("C:\\Users\\subra\\git\\frame\\framework\\Testdata\\exceldata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			System.out.println("unable to find the file"+ e.getMessage());
		}
	}

	public String getstringdata(String sheetname, int row, int cell) {
		return workbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	public String getstringdata(int sheetnumber, int row, int cell) {
		return workbook.getSheetAt(sheetnumber).getRow(row).getCell(cell).getStringCellValue();
	}

	public double getNumericvalue(String sheetname, int row, int cell) {

		return workbook.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}
	public double getNumericvalue(int sheetnumber, int row, int cell) {

		return (int) workbook.getSheetAt(sheetnumber).getRow(row).getCell(cell).getNumericCellValue();
	}
}
