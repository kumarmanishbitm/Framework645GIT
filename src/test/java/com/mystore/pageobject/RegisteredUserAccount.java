package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	
	// Create obj of webdriver
			WebDriver ldriver; // local driver
			
			// create a constructor and initialize the webElements
			public RegisteredUserAccount(WebDriver rdriver){ // remote driver is used to search webelements
				ldriver= rdriver;
				PageFactory.initElements(rdriver, this);
			}
			
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement logoutBtn;
	
	public String getUserName(){
		String text = userName.getText();
		return text;
	}
	
	public void clickOnLogoutBtn(){
		
		logoutBtn.click(); 
	}

}
