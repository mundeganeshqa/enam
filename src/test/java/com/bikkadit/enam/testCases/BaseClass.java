package com.bikkadit.enam.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.bikkadit.enam.util.ReadConfig;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getAppliactionURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getPassword();	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public static void setup( @Optional("chrome") String browser) {
		
		 logger = Logger.getLogger("enam");
		 PropertyConfigurator.configure("log4j.properties");

		if(browser.equals("chrome")) {
			
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver1//chromedriver.exe" );
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Driver1//geckodriver.exe" );
		driver = new FirefoxDriver();
		}
		
		else {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Driver1//msedgedriver.exe" );
			driver = new EdgeDriver();
		}		
		
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

}
