package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	// create a constructor and initialize the webElements
		public SauceLoginPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="user-name")
		WebElement userName;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="login-button")
		WebElement login;
	
		public void enterUsername(String username){
			userName.sendKeys(username);
		}
		
		public void enterPassword(String pwd){
			password.sendKeys(pwd);
		}
		
		public void clickOnLoginBtn(){
			login.click();
		}
}
