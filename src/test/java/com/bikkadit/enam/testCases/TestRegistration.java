package com.bikkadit.enam.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.testng.annotations.Test;

import com.bikkadit.enam.pageObject.LoginPage;
import com.bikkadit.enam.pageObject.Registration;

public class TestRegistration extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.get(baseUrl);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		Registration addcust=new Registration(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		Thread.sleep(1000);
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		//String email=randomestring()+"@gmail.com";
		addcust.custemailid("mundeganesh212@gmail.com");
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			assertTrue(false);
		}
			
	}

}
