package com.Selenium.Pages;

import org.openqa.selenium.By;

public class HomePage {
	
	public String sitename() {
		String name=BaseClass.excelElementLocater.getObjectData("Home_WebsiteName");
		return BaseClass.driver.findElement(By.xpath(name)).getText();
		 
	}
	
	public static void tableLink(String testcase) {
		try {

			String table = BaseClass.excelElementLocater.getObjectData("Table_TableLink");
			BaseClass.driver.findElement(By.xpath(table)).click();
			
			BaseClass.extentReports.logReport(testcase, "Cliked on Table Link", "PASS", " ");
			BaseClass.pdfRportGenerator.pdfReport();
			
		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("tableLink() - Click on table link ", e.toString());
		}
	}
	
	public void tablePagination(String testcase) {
		HomePage.tableLink(testcase);
		try {
			String tablePagination = BaseClass.excelElementLocater.getObjectData("Table_TablePagination");
			BaseClass.driver.findElement(By.xpath(tablePagination)).click();
			
			BaseClass.extentReports.logReport(testcase, "Cliked on Table Pagination Link", "PASS", " ");
			BaseClass.pdfRportGenerator.pdfReport();
			
		} catch (Exception e) {
			BaseClass.exceptionHandler.errorMessage("pageNavigation() - Click on table link >> TablePagination ",
					e.toString());
		}
	}
	
	public void tableDataSearch(String testcase) {
		HomePage.tableLink(testcase);
		try {
			String tableDataSearch = BaseClass.excelElementLocater.getObjectData("Table_TableDataSearch");
			BaseClass.driver.findElement(By.xpath(tableDataSearch)).click();
			
			BaseClass.extentReports.logReport(testcase, "Cliked on Table Data Search Link", "PASS", " ");
			BaseClass.pdfRportGenerator.pdfReport();
		}
		catch(Exception e) {
			BaseClass.exceptionHandler.errorMessage("tableDataSearch() - Click on table link >> TableDataSearch ",
					e.toString());
		}
	}

}
