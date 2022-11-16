package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceCartPage {
	
	// Create obj of webdriver
	WebDriver ldriver; // local driver
	
	// create a constructor and initialize the webElements
		public SauceCartPage(WebDriver rdriver){ // remote driver is used to search webelements
			ldriver= rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="shopping_cart_container")
		WebElement cart;
		
		@FindBy(id="checkout")
		WebElement checkout;
	
		public void clickOnCartBtn(){
			cart.click();
		}
		public void clickOnCheckOutBtn(){
			checkout.click();
		}
		
		
}
