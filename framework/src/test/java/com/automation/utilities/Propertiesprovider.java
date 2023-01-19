package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesprovider {
	Properties pro;

	public Propertiesprovider() {

		File file = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {

			System.out.println("properties file not loades:" + e.getMessage());
		}
	}

	public String getusername() {
		return pro.getProperty("USERNAME");
		

	}

	public String getpassword() {
		return pro.getProperty("PASSWORD");

	}

	public String geturl() {
		return pro.getProperty("URL");
	}

	public String Browsername() {
		return pro.getProperty("BROWSER");
	}

	public String getDatafromconfig(String keyvalue) {
		return pro.getProperty(keyvalue);
	}

}
