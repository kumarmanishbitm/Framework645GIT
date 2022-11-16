package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	// Create obj of webdriver
		WebDriver ldriver; // local driver
		
		// create a constructor and initialize the webElements
		public MyAccount(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="email_create")
		WebElement createEmailId;
		
		@FindBy(id="SubmitCreate")
		WebElement submitCreate;
		
		@FindBy(id="email")
		WebElement registeredUsername;
		
		@FindBy(id="passwd")
		WebElement registeredPassword;
		
		@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
		WebElement submitLogin;
		
		public void enterEmailAddress(String emailAddress){
			createEmailId.sendKeys(emailAddress);
		}
		
		public void clickOnSubmitCreateBtn(){
			submitCreate.click();
		}
		
		public void enterLoginEmail(String emailLogin){
			registeredUsername.sendKeys(emailLogin);
		}
		
		public void enterLoginPassword(String passwordLogin){
			registeredPassword.sendKeys(passwordLogin);
		}
		
		public void clickOnLoginBtn(){
			submitLogin.click();
		}
	

}
