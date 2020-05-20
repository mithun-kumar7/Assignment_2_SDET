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
import com.qa.pageObjects.GermanPage;
import com.qa.utils.ExcelTestUtil;



public class GermanPageTest extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);
	
	GermanPage germanPage;
	
	static String projectPath = System.getProperty("user.dir");
	static String excelPath=projectPath + "/src/test/resources/testData/registration.xlsx";
	
	@BeforeMethod
	public void setUp(Method m) throws IOException {
		logger.info("\n"+"********** starting test: *********"+m.getName()+"***********"+"\n");
		initialise();
		germanPage = new GermanPage();
	}
	
	@DataProvider
	public Object[][] getRegistrationData() throws IOException {
		Object data[][] = ExcelTestUtil.getTestData(excelPath,"German");
		return data;
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void registerationInGermanTest(String ftname, String ltName, String email, String pwd, String cnfPwd, int day,
			int month, int year, String land, String stName, int ptCode, String place) throws InterruptedException {
		germanPage.navigateToGermanPage();
		germanPage.clickOnRegistrationLink();
		germanPage.fillRegistrationForm(ftname, ltName, email, pwd, cnfPwd, day, month, year, land, stName, ptCode, place);
		Thread.sleep(8000);
	}
	
	@Test()
	public void germanSignInTest() {
		germanPage.navigateToGermanPage();
		germanPage.clickOnSignInLink();
		germanPage.loginToSite("mithunkr0123@gmail.com", "testdata1234");
	}
	
	@AfterMethod
	public void teardown(Method m) {
		driver.quit();
		logger.info("Chrome browser is closed");
		logger.info("\n"+"********** Test is completed: *********"+m.getName()+"***********"+"\n");
	}

}
