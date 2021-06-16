package com.Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Selenium.Pages.BaseClass;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfRportGenerator {

	Document document;
	String output;
	FileOutputStream fos;
	byte[] input;
	PdfWriter writer;
	Image im;

	public void pdfReportInit() throws FileNotFoundException, DocumentException {
		document = new Document();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		// output = System.getProperty("user.dir") + "/PDFReport/" +
		// System.currentTimeMillis() + ".pdf";
		output = System.getProperty("user.dir") + "/PDFReport/" + timeStamp + ".pdf";

		fos = new FileOutputStream(output);

		// Capture screenshot and store it in byte[] array format
		// input = ((TakesScreenshot)
		// BaseClass.driver).getScreenshotAs(OutputType.BYTES);

		// Instantiate the PDF writer
		writer = PdfWriter.getInstance(document, fos);

		// open the pdf for writing
		writer.open();
		document.open();

		// process content into image
        //im = Image.getInstance(input);

		// set the size of the image
		// im.scaleToFit(PageSize.A4.getWidth() / 1, PageSize.A4.getHeight() / 1);

	}

	public void pdfReporName(String testcase) throws DocumentException {
		//document.addSubject(testcase);
		//Paragraph para = new Paragraph(" ");
		Paragraph para = new Paragraph("TestCase: "+testcase);
		//para.Alignment = Element.ALIGN_CENTER;  
		//para.alignme
		document.add(para);
		//document.newPage();

	}

	public void pdfReport() throws DocumentException, MalformedURLException, IOException {

		// Capture screenshot and store it in byte[] array format
		input = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
		
		// process content into image
		im = Image.getInstance(input);


		// set the size of the image
		im.scaleToFit(PageSize.A4.getWidth() / 1, PageSize.A4.getHeight() / 1);

		// add the captured image to PDF
		document.add(im);
		Paragraph para = new Paragraph(" ");
		document.add(para);
	}

	public void endPdfReport() {
		// close the files and write to local system
		document.close();
		writer.close();
	}

}
