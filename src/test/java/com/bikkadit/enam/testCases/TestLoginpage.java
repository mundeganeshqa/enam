package com.bikkadit.enam.testCases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.bikkadit.enam.pageObject.LoginPage;

public class TestLoginpage extends BaseClass {
	
	@Test
	public void loginTest() throws IOException 	{
			
		
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enterd username");
		
		
		lp.setPassword(password);
	    logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			captureScreen(driver,"logintest");
			logger.info("Test case failed");
			assertTrue(false);
			
		}
		
		
	}
	

}
