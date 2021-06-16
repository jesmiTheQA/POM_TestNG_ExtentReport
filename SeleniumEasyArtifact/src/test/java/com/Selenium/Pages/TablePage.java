package com.Selenium.Pages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.text.DocumentException;

public class TablePage {

String xPathLocater;

	public int numberOfRecords() {
		int number=0;
		try {
			String numberOfData = BaseClass.excelElementLocater.getObjectData("Table_NumberOfData");
			number=BaseClass.driver.findElements(By.xpath(numberOfData)).size();
			
			
		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("numberOfRecords() - Number of records.", e.toString());
			
		}
		return number;
	}
	
	public void filterByTask(String testcase) throws MalformedURLException, DocumentException, IOException {
		BaseClass.homePage.tableDataSearch(testcase);
		
		xPathLocater = BaseClass.excelElementLocater.getObjectData("Table_FilterByTaskAssigneStatus");
		BaseClass.driver.findElement(By.xpath(xPathLocater)).click();
		BaseClass.extentReports.logReport(testcase, " Clicked on Filter By Task/Assigne/Status ", "PASS", " ");
		BaseClass.pdfRportGenerator.pdfReport();
		
		
		String task=BaseClass.excelDataProvider.GetTestData("Table_Task");
		BaseClass.driver.findElement(By.xpath(xPathLocater)).sendKeys(task);
		
		BaseClass.extentReports.logReport(testcase, " Provided the Task", "PASS", " ");
		BaseClass.pdfRportGenerator.pdfReport();
	}

}
