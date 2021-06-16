package com.Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.Utilities.BrowserSelection;
import com.Utilities.ExcelDataProvider;
import com.Utilities.ExcelElementLocater;
import com.Utilities.ExceptionHandler;
import com.Utilities.ExtentReport;
import com.Utilities.NumberConvertionToWords;
import com.Utilities.PdfRportGenerator;

public class BaseClass {

	public static WebDriver driver;
	public static ExcelDataProvider excelDataProvider = new ExcelDataProvider();
	public static ExcelElementLocater excelElementLocater = new ExcelElementLocater();
	public static ExceptionHandler exceptionHandler = new ExceptionHandler();
	public static BrowserSelection browserSelection = new BrowserSelection();
	public static HomePage homePage = new HomePage();
	public static TablePage tablePage = new TablePage();
	public static ExtentReport extentReports = new ExtentReport();
	public static PdfRportGenerator pdfRportGenerator = new PdfRportGenerator();
	public static NumberConvertionToWords numberConvertionToWords = new NumberConvertionToWords();

	public BaseClass() {

	}

	@BeforeClass
	public void setUP() {
		extentReports.init();
		try {
			pdfRportGenerator.pdfReportInit();
		} catch (Exception e) {
			exceptionHandler.errorMessage("setUP() - pdfReportInit ", e.toString());
		}
		browserSelection.selectionBrowser();
		browserSelection.manageBrowser();
		String popUpClose = excelElementLocater.getObjectData("Home_PopUpClose");
		driver.findElement(By.xpath(popUpClose)).click();
		// BaseClass.driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	}

	@AfterClass
	public void tearDown() {
		browserSelection.closeBrowser();
		// extentReports.endReport(); // get separate report
		pdfRportGenerator.endPdfReport();

	}

	@AfterSuite
	public void clearDown() {
		extentReports.endReport();
	}
}
