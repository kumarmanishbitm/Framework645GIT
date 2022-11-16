package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProductPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver

	// create a constructor and initialize the webElements
		public SauceProductPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
		WebElement productName;
		
		@FindBy(id="add-to-cart-sauce-labs-backpack")
		WebElement addToCartButton;
	
		public void clickOnProductName(){
			productName.click();
		}
		
		public void clickOnAddToCartButton(){
			addToCartButton.click();
		}
}
