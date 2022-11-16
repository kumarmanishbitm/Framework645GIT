package com.mystore.testcases;

import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_AccountPageTestDatadrivenTesting extends BaseClass{
	

	@Test(dataProvider = "LoginDataProvider")
	public void verifylogin(String userEmail, String userPwd, String expectedUsername) throws IOException{
		
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnSignInButton();
		
		MyAccount myAcc = new MyAccount(driver);
		
		myAcc.enterLoginEmail(userEmail);
		logger.info("Email id entered");
		myAcc.enterLoginPassword(userPwd);
		logger.info("Password entered");
		myAcc.clickOnLoginBtn();
		logger.info("Clicked on Login Button");
		
		// verify username displaying on My Account page
		RegisteredUserAccount rnv = new RegisteredUserAccount(driver);		
		String vusername=	rnv.getUserName();
		
		if(vusername.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			rnv.clickOnLogoutBtn();
			logger.info("Clicked on Logout button successfully.");
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}
		
		logger.info("***************TestCase Verify login ends*****************");		
		
	}
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
