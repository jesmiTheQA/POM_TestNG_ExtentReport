package com.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Selenium.Pages.BaseClass;

public class PdfScreenshotGenerator {
	public static String evidenceCapture(Integer testRunNo, String screenShotName) {
		String evidencePath = null;
	    try {
	    	String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
	    	
	        TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	      
	      //  evidencePath = System.getProperty("user.dir") + File.separator + "/test-output/FrameworkScreenshots/"+ testRunNo+ "_"+ System.currentTimeMillis()+".png";
	       evidencePath = System.getProperty("user.dir") + "/PDFReportt/"+ timeStamp+".pdf";
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
