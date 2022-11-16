package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;


public class TC_MyAccountLoginPageTest extends BaseClass{
	
	@Test
	public void verifyRegistrationandLogin() throws InterruptedException, IOException{
		
		driver.get(url);
		logger.info("url opened");
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignInButton();
		logger.info("Clicked on Sign In button successfully.");	
		
		MyAccount myAcc = new MyAccount(driver);
		myAcc.enterLoginEmail("manishtest1@gmail.com");
		logger.info("Login Email entered successfully.");
		myAcc.enterLoginPassword("manish_123");		
		logger.info("Login Password entered successfully.");
		myAcc.clickOnLoginBtn();
		logger.info("Clicked on Login Button successfully.");

		// verify username displaying on My Account page
		RegisteredUserAccount rnv = new RegisteredUserAccount(driver);		
		String vusername=	rnv.getUserName();
		
		if(vusername.equals("Mk kumar"))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}
	
		
	}

}
