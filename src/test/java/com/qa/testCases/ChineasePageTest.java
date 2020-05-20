package com.qa.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase;
import com.qa.pageObjects.ChineasePage;

public class ChineasePageTest extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);

	ChineasePage chineasePage;

	@BeforeMethod
	public void setUp(Method m) throws IOException {
		logger.info("\n"+"********** starting test: *********"+m.getName()+"***********"+"\n");
		initialise();
		chineasePage = new ChineasePage();
	}

	@Test()
	public void chineaseLoginTest() throws InterruptedException {
		chineasePage.navigateToChineasePage();
		chineasePage.clickOnSignInLink();
		chineasePage.logInToSite("mithunkr0123@gmail.com", "testdata1234");
		Thread.sleep(5000);
	}

	@Test()
	public void chineaseRegistrationTest() throws IOException, ParseException, InterruptedException {
		chineasePage.navigateToChineasePage();
		chineasePage.clickOnRegisterLink();
		chineasePage.fillRegistrationForm();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown(Method m) {
		driver.quit();
		logger.info("Chrome browser is closed");
		logger.info("\n"+"********** Test is completed: *********"+m.getName()+"***********"+"\n");
	}
}
