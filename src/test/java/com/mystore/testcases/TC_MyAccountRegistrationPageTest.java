package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;

public class TC_MyAccountRegistrationPageTest extends BaseClass{
	
	@Test
	public void verifyRegistrationandLogin() throws InterruptedException{
		
		driver.get(url);
		logger.info("url opened");
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignInButton();
		logger.info("Clicked on Sign In button successfully.");	
		
		MyAccount myAcc = new MyAccount(driver);
		myAcc.enterEmailAddress("selenium64511@test.com");
		logger.info("Email address entered successfully.");
		myAcc.clickOnSubmitCreateBtn();
		logger.info("Clicked on Create Button successfully.");
	//	Thread.sleep(5000);
		
		AccountCreationDetails acd =  new AccountCreationDetails(driver);
		acd.selectTitle();
		acd.enterFirstName("Selenium");
		acd.enterLastName("Testtt");
		acd.enterPassword("selenium645");
		acd.enterAddFname("Selenium");
		acd.enterAddLname("Test");
		acd.enterAddress("18/8 worli road");
		acd.enterCityNamecity("Mumbai");
		acd.selectState("Alabama");
		acd.enterZip("00000");
		acd.selectCountry("United States");
		acd.enterphoneNumber("8978675698");
		acd.enterAliasName("Home");
		logger.info("Entered all required details for registration process.");
		acd.clickonRegBtn();
		logger.info("Clicked on Registration Button successfully.");
		
		RegisteredUserAccount rua =  new RegisteredUserAccount(driver);
		String username = rua.getUserName();
		Assert.assertEquals("Selenium Testtt", username);
		
	}

}
