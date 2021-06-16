package com.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Selenium.Pages.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void init() {

		try {
			// To create Extent-Report folder if it is not existing
			File theDir = new File(System.getProperty("user.dir") + "/ExtentReports/");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
			String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/ExtentReports/ExtentReport_" + timeStamp + ".html");
			extent = new ExtentReports();

			extent.attachReporter(htmlReporter);
			htmlReporter.config().setDocumentTitle("Web Automation Report"); // Title of Report

			htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
			htmlReporter.config().setTheme(Theme.DARK);// Default Theme of Report

			// General information related to application
			
			String application=BaseClass.excelDataProvider.GetTestData("Common_Application");
			extent.setSystemInfo("Application Name", application);
			extent.setSystemInfo("User Name", System.getProperty("user.host"));
			String browser=BaseClass.excelDataProvider.GetTestData("Common_Browser");
			extent.setSystemInfo("Environment", "WINDOWs-"+browser);

			// test = extent.createTest("ABC");

		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("init()", e.toString());
		}

	}

	public void logReport(String testCaseName, String testStepName, String result, String failureReason) {
		try {
			// testCase(testCaseName);
			String screenshotPath = ScreenshotGenerator.evidenceCapture(1, testCaseName + "_" + testStepName);
			if (result != null && result.equalsIgnoreCase("PASS")) {
				test.log(Status.PASS,
						MarkupHelper.createLabel(testCaseName + " - " + testStepName + " : Passed", ExtentColor.GREEN));
				test.log(Status.PASS, "Snapshot : " + test.addScreenCaptureFromPath(screenshotPath));
			} else {
				// test.log(Status.PASS,MarkupHelper.createLabel(testCaseName + " - " +
				// testStepName + " : Failed", ExtentColor.RED));
				// test.log(Status.FAIL,MarkupHelper.createLabel(testCaseName + " - " +
				// testStepName + " : Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(
								testCaseName + " - " + testStepName + " : Failed" + " - Reason :" + failureReason,
								ExtentColor.RED));
				test.log(Status.FAIL, "Snapshot : " + test.addScreenCaptureFromPath(screenshotPath));
			}
			// endReport();
		} catch (Exception e) {
			// e.printStackTrace();
			BaseClass.exceptionHandler.errorMessage("logReport()", e.toString());
		}
	}

	public void endReport() {
		try {
			extent.flush();

		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("endReport()", e.toString());
		}

	}

	public void testCase(String testCaseName) {
		test = extent.createTest(testCaseName);
	}

	

}
