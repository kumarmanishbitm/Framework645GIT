package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties property;
	
	String path= "D:\\Manish\\Framework645\\Configuration\\Config.properties";
	
	public ReadConfig(){ // create cont to initialize properties object
	try{
		property = new Properties();
	FileInputStream fis = new FileInputStream(path);
	property.load(fis);
	
	}catch(Exception e){
		e.printStackTrace();
	}
}
	public String getBaseUrl(){
	String value=property.getProperty("baseUrl");
		// check if value is not null
	if(value!=null)
		return value;
	else
		throw new RuntimeException("URL not found in config file");
	}
	
	public String getBrowser(){
		String value=property.getProperty("browser");
			// check if value is not null
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Browser not found in config file");
		}
}
