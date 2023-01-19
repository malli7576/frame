package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helperclass {

	public static String caputurescreenshot(WebDriver driver) throws IOException {
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/amazon" + getCurrentDateTime() + ".png";
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotpath);
		
		// File dest = new File("./Screenshots/amazon" + getCurrentDateTime() + ".png");
		// FileUtils.copyFile(src, dest);
	
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		System.out.println("screenshot captured");
		return screenshotpath;

	}

	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("YYYY_MM_dd_HH_mm-ss");
		Date currentdate = new Date();
		return customformat.format(currentdate);

	}

}
