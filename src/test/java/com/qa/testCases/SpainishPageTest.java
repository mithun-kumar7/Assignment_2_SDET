package com.qa.testCases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestBase;
import com.qa.pageObjects.SpanishPage;
import com.qa.utils.ExcelTestUtil;



public class SpainishPageTest extends TestBase {
	private static Logger logger=LogManager.getLogger(TestBase.class);
	
	SpanishPage spanishPage;
	
	static String projectPath = System.getProperty("user.dir");
	static String excelPath=projectPath + "/src/test/resources/testData/registration.xlsx";
	
	@BeforeMethod
	public void setUp(Method m) throws IOException {
		logger.info("\n"+"********** starting test: *********"+m.getName()+"***********"+"\n");
		initialise();
		spanishPage = new SpanishPage();
	}
	
	@DataProvider
	public Object[][] getRegistrationData() throws IOException {
		Object data[][] = ExcelTestUtil.getTestData(excelPath,"Spain");
		return data;
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void registerationInSpenish(String ftname, String ltName, String email, String pwd, String cnfPwd, int day,
			int month, int year, int phoneNumber) throws InterruptedException {
		spanishPage.navigateToSpenishPage();
		spanishPage.clickOnRegistrationLink();
		spanishPage.fillRegistrationForm(ftname, ltName, email, pwd, cnfPwd, day, month, year, phoneNumber);
		Thread.sleep(8000);
	}
	
	@Test()
	public void spenishSignInTest() {
		spanishPage.navigateToSpenishPage();
		spanishPage.clickOnSignInLink();
		spanishPage.loginToSite("mithunkr0123@gmail.com", "testdata1234");
	}
	
	
	@AfterMethod
	public void teardown(Method m) {
		driver.quit();
		logger.info("Chrome browser is closed");
		logger.info("\n"+"********** Test is completed: *********"+m.getName()+"***********"+"\n");
	}

}
