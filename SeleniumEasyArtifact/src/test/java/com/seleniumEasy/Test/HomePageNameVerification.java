package com.seleniumEasy.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.Selenium.Pages.BaseClass;
import com.Utilities.ExcelDataProvider;
import com.Utilities.ExtentReport;
import com.aventstack.extentreports.ExtentReports;

public class HomePageNameVerification extends BaseClass {
	
//	@BeforeClass
//	public void setUp() {
//		browserSelection.selectionBrowser();
//	}
	
	@Test
	public void homeVerification() {
		try {
			extentReports.testCase("Home Page Verification");
			BaseClass.pdfRportGenerator.pdfReporName("Home Page Verification");
			
			String expectedName=BaseClass.homePage.sitename();
			System.out.println("expectedName: "+expectedName);
			String actualName=BaseClass.excelDataProvider.GetTestData("Home_HomePageName");
			System.out.println("actualName : "+actualName);
			if(actualName.equals(expectedName) ){
				System.out.println("Home page verification - Pass");
				BaseClass.extentReports.logReport("Home Page Verification", "Website name Verification is success", "PASS", " ");
				BaseClass.pdfRportGenerator.pdfReport();
			}
			else {
				System.out.println("Home page verification - Fail");
			}
			
		}
		catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("homeVerification()", e.toString());
		}
		
		
	}


//	@AfterClass
//	public void tearDown() {
//		
//	}
}
