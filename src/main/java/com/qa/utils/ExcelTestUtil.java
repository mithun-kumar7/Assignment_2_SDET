package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestUtil {

	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	public static Object[][] getTestData(String excelPath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(excelPath);
		book = new XSSFWorkbook(file);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				row = sheet.getRow(i + 1);
				cell = row.getCell(j);

				if (cell.getCellType() == CellType.STRING) {
					data[i][j] = cell.getStringCellValue();
					continue;
				} else if (cell.getCellType() == CellType.NUMERIC) {
					data[i][j] = (int) cell.getNumericCellValue();
					continue;
				} else if (cell.getCellType() == CellType.BOOLEAN) {
					data[i][j] = cell.getBooleanCellValue();
					continue;
				}

			}
		}
		return data;

	}

}
