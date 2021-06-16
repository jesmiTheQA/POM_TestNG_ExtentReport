package com.Utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Selenium.Pages.BaseClass;



public class BrowserSelection {
	public void selectionBrowser(){
		
		// To create Drivers folder if it is not existing
		File driversFolder = new File(System.getProperty("user.dir") + "/Drivers/");
		if (!driversFolder.exists()) {
			driversFolder.mkdirs();
		}
		

		
		try {
			String browser=(BaseClass.excelDataProvider.GetTestData("Common_Browser")).toLowerCase();
			if(browser.contains("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
				BaseClass.driver=new ChromeDriver();
			}
			else if(browser.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers//geckodriver.exe");
				BaseClass.driver=new FirefoxDriver();
			}
			else if(browser.contains("edge"))
			{
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "/Drivers/msedgedriver.exe");
				BaseClass.driver=new EdgeDriver();
			}
			else {
				System.out.println("Sorry..Something went wrong..!");
			}
		}
		catch(Exception e) {
			BaseClass.exceptionHandler.errorMessage("selectionBrowser():", e.toString());
		}

	}
	
	//To manage the browser
		public void manageBrowser() {
			try {
				String url=BaseClass.excelDataProvider.GetTestData("Common_URL");
				BaseClass.driver.manage().window().maximize();
				BaseClass.driver.manage().deleteAllCookies();
				BaseClass.driver.get(url);
				BaseClass.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			catch(Exception e){
				BaseClass.exceptionHandler.errorMessage("manageBrowser()", e.toString());
			}
		}
		
		//To close the browser
		public void closeBrowser() {
			try {
				Thread.sleep(1000);
				BaseClass.driver.close();
				BaseClass.driver.quit();
			}
			catch(Exception e) {
				BaseClass.exceptionHandler.errorMessage("closeBrowser()", e.toString());
			}
		}

}
