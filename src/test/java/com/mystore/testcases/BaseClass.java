package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	String url=readConfig.getBaseUrl();
	String browser= readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp(){
		
		switch (browser.toLowerCase()){
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
		
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		
		default:
			driver= null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// for logging use log4j, 
		logger= LogManager.getLogger("Framework645");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	//user method to capture screen shot
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
			{
				//step1: convert webdriver object to TakesScreenshot interface
				TakesScreenshot screenshot = ((TakesScreenshot)driver);
				
				//step2: call getScreenshotAs method to create image file
				
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				
				File dest = new File(System.getProperty("user.dir") + "./Screenshots/" + testName + ".png");
			
				//step3: copy image file to destination
				FileUtils.copyFile(src, dest);
			}

}
