package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceCompletePage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	// create a constructor and initialize the webElements
		public SauceCompletePage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
		WebElement successMsg;
		
	
		public void getSuccessMsg(){
			String msg = successMsg.getText();
			
			System.out.println("Product page title is :" + msg);
			
			if(msg.equals("THANK YOU FOR YOUR ORDER"))
			{
			
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("Success message not displaying.");
			}
			
	
		}
}
