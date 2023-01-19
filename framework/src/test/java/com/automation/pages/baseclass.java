package com.automation.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utilities.Browserlanuch;
import com.automation.utilities.Exceldatareader;
import com.automation.utilities.Helperclass;
import com.automation.utilities.Propertiesprovider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public WebDriver driver;
	public Exceldatareader ex;
	public Propertiesprovider property;
	public ExtentReports extentReports;
	public ExtentTest logger;

	@BeforeSuite
	public void setup() throws IOException {

		ex = new Exceldatareader();
		property = new Propertiesprovider();

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(
				"./ExtentReports/" + Helperclass.getCurrentDateTime() + "extentreports.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkreporter);
	}

	//@Parameters({"browser","testingurl"})
	@BeforeClass
	public void class1() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		driver = Browserlanuch.startbrowser(driver, property.Browsername(), property.geturl());
	//	driver = Browserlanuch.startbrowser(driver, browser, url);

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				Helperclass.caputurescreenshot(driver);
			} catch (Exception e) {

				System.out.println("caputured problem" + e.getMessage());
			}
			logger.fail("testcasefailed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helperclass.caputurescreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS)
			logger.pass("test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helperclass.caputurescreenshot(driver)).build());

		extentReports.flush();

	}
}
