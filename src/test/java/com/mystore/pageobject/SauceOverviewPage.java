package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceOverviewPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	// create a constructor and initialize the webElements
		public SauceOverviewPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="finish")
		WebElement finishBtn;
		
	
		public void clickOnFinishBtn(){
			finishBtn.click();
		}
}
