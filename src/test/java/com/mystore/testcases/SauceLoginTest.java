package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mystore.pageobject.SauceLoginPage;
import com.mystore.utilities.ExtentListener;

//@Listeners(ExtentListener.class)
public class SauceLoginTest extends BaseClass{
	
	@Test
	public void verifyLogin() throws InterruptedException, IOException{
		
		driver.get(url);
		logger.info("url opened");
		
		SauceLoginPage lp = new SauceLoginPage(driver);
		
		lp.enterUsername("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickOnLoginBtn();
		
		String title = driver.getTitle();
		System.out.println("Product page title is :" + title);
		
		if(title.equals("Swag Labs"))
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