package com.seleniumEasy.Test;

import org.testng.annotations.Test;

import com.Selenium.Pages.BaseClass;

public class TablePageVerifications extends BaseClass {
	@Test(priority = 2, enabled=true)
	public void dataVerification() throws InterruptedException {
		try {
			String testcase="Data Verification in Table";
			BaseClass.extentReports.testCase(testcase);
			BaseClass.pdfRportGenerator.pdfReporName(testcase);
			BaseClass.homePage.tablePagination(testcase);
			
			int NumberOfRecordsInTable =BaseClass.tablePage.numberOfRecords();
			String Num1=BaseClass.numberConvertionToWords.convert(NumberOfRecordsInTable);	
			String NumberOfRecordsInTestData=BaseClass.excelDataProvider.GetTestData("Table_NumberOfRecordsInTable");
			if(Num1.equalsIgnoreCase(NumberOfRecordsInTestData)) {
				System.out.println("Data Verification in Table is Pass");
				BaseClass.extentReports.logReport("Data Verification in Table", " Data Verification is success", "PASS", " ");
				BaseClass.pdfRportGenerator.pdfReport();
			}
			else {

				System.out.println("Data Verification in Table is Fail");
			BaseClass.extentReports.logReport("Data Verification in Table", " Data Verification is failed", "Fail", " ");
			}
		}
		catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("DataVerification()", e.toString());
		}

		Thread.sleep(1000);
	}
	
	@Test(priority = 1,enabled=true)
	public void filterByTaskVerification() throws InterruptedException {
		
		try {
			String testcase="Filter by Task Verification in Table";
			BaseClass.extentReports.testCase(testcase);
			BaseClass.pdfRportGenerator.pdfReporName(testcase);
			BaseClass.tablePage.filterByTask(testcase);
			
			//verification not done
			
			//System.out.println("Filter by Task Verification in Table is Pass");
		}
		catch(Exception e) {
			BaseClass.exceptionHandler.errorMessage("filterByTaskVerification()", e.toString());
		}
		Thread.sleep(1000);
	}

}
