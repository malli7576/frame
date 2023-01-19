package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class amazonLoginpage {
	WebDriver driver;

	public amazonLoginpage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(id = "nav-link-accountList")
	WebElement loginbutton;
	@FindBy(id = "ap_email")
	WebElement signin;
	@FindBy(id = "ap_password")
	WebElement pass;
@FindBy(id = "twotabsearchtextbox") WebElement search;
	public void login(String username, String password) {
		

		loginbutton.click();
		signin.sendKeys(username,Keys.ENTER);
		pass.sendKeys(password,Keys.ENTER);
		
	}
		
	public void clickloginbutton() {
		loginbutton.click();
	}

	public void enterusername(String username) {
		signin.sendKeys(username, Keys.ENTER);
	}

	public void enterpassword(String password) {
		pass.sendKeys(password, Keys.ENTER);

	}
	public void clicksearchbar() {
		search.sendKeys("laptop",Keys.ENTER);
	}
}
