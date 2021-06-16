package com.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Selenium.Pages.BaseClass;


public class ScreenshotGenerator {
	public static String evidenceCapture(Integer testRunNo, String screenShotName) {
		String evidencePath = null;
		
		// To create Screenshots folder if it is not existing
		File theDir = new File(System.getProperty("user.dir") + "/Screenshots/");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		
		
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		
	    try {
	        TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        evidencePath = System.getProperty("user.dir") +"/Screenshots/"+timeStamp+".png";
	      //  evidencePath = System.getProperty("user.dir") + File.separator + "/test-output/FrameworkScreenshots/"+ testRunNo+ "_"+ System.currentTimeMillis()+".png";
	       // evidencePath = System.getProperty("user.dir") + File.separator + "/test-output/FrameworkScreenshots/"+ testRunNo+ "_"+ System.currentTimeMillis()+".pdf";
	        File destination = new File(evidencePath);
	        FileUtils.copyFile(source, destination);                      
	        return evidencePath;
	    } catch(Exception e){
	    	//e.printStackTrace();
	    	BaseClass.exceptionHandler.errorMessage("evidenceCapture()", e.toString());
	    	
	    }
	    return evidencePath;
	}
	

}
