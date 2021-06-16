package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Selenium.Pages.BaseClass;

public class ExcelDataProvider {
	public static HashMap<String, String> hmTestData = new HashMap<String, String>();
	static String sValue;

	public void toReadfromsheet() {

		try {

			// To create TestData folder if it is not existing
			File theDir = new File(System.getProperty("user.dir") + "/TestData/");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
			
			
			File src = new File(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
			InputStream fis = new FileInputStream(src);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			Iterator<Sheet> sheetIterator = workbook.iterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Cell cell = row.getCell(0);
					// cell.setCellType(cell.CELL_TYPE_STRING);
					String sKey = cell.getStringCellValue();
					cell = row.getCell(1);
					// cell.setCellType(cell.CELL_TYPE_STRING);
					sValue = cell.getStringCellValue();
					hmTestData.put(sheet.getSheetName() + "_" + sKey, sValue);
				}
			}
			workbook.close();
		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("toReadfromsheet()", e.toString());

		}
	}

	public String GetTestData(String sKey) {
		try {
			toReadfromsheet();
			return hmTestData.get(sKey);
		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("GetTestData()", e.toString());
			return null;
		}
	}

}
