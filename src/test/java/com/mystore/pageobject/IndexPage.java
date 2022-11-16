package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	// create a constructor and initialize the webElements
		public IndexPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
	
		public void clickOnSignInButton(){
			
			signIn.click();
		}
}
