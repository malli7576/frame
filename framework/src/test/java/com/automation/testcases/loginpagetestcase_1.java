package com.automation.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.amazonLoginpage;
import com.automation.pages.baseclass;
import com.automation.utilities.Browserlanuch;
import com.automation.utilities.Exceldatareader;
import com.automation.utilities.Helperclass;

public class loginpagetestcase_1 extends baseclass {

	@Test
	public void loginhomepage() {
		logger = extentReports.createTest("Login to Amazon");

		amazonLoginpage log = PageFactory.initElements(driver, amazonLoginpage.class);
		logger.info("logging to application");

		log.login(ex.getstringdata("Login", 0, 0), ex.getstringdata("Login", 0, 1));// data from excel file
		// log.login(property.getusername(), property.getpassword());// data from
		// properties file

		logger.pass("logging to application successful");

	}

	@Test
	public void loginhomepage1() {
		logger = extentReports.createTest("second login");
		logger.info("second test case started");
		amazonLoginpage log = PageFactory.initElements(driver, amazonLoginpage.class);
//		log.login(property.getusername(), property.getpassword());// data from properties file
//		logger.info("test case done");
		
		// these there are indivudal methods.

//		log.clickloginbutton();
//		log.enterusername(property.getusername());
//		log.enterpassword( property.getpassword());
		log.clicksearchbar();
	}

}