package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceInformationPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	// create a constructor and initialize the webElements
		public SauceInformationPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="first-name")
		WebElement firstName;
		
		@FindBy(id="last-name")
		WebElement lastName;
		
		@FindBy(id="postal-code")
		WebElement postalCode;
		
		@FindBy(id="continue")
		WebElement continueBtn;
	
		public void enterFirstName(String firstname){
			firstName.sendKeys(firstname);
		}
		
		public void enterLastName(String lastname){
			lastName.sendKeys(lastname);
		}
		
		public void enterPostalCode(String postalcode){
			postalCode.sendKeys(postalcode);
		}
		
		public void clickOnContinueBtn(){
			continueBtn.click();
		}
}
