package com.bikkadit.enam.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bikkadit.enam.pageObject.LoginPage;
import com.bikkadit.enam.util.XLUtils;

public class TestLoginPageDDT extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws IOException, InterruptedException {

		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("Enterd username");

		lp.setPassword(pwd);
		logger.info("Entered Password");

		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			assertTrue(false);

		} else {
			assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}
	}

	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "./src/test/java/com/bikkadit/enam/testData/LoginData1.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowNum][colCount];
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return logindata;

	}

}
