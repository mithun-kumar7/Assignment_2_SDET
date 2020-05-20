package com.qa.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase;
import com.qa.pageObjects.EnglishPage;



public class EnglistPageTest extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);

	EnglishPage englishPage;

	@BeforeMethod
	public void setUp(Method m) throws IOException {
		logger.info("\n"+"********** starting test: *********"+m.getName()+"***********"+"\n");
		initialise();
		englishPage = new EnglishPage();
	}

	@Test
	public void registrationTest() throws InterruptedException {
		englishPage.clickOnRegisterLink();
		englishPage.enterEmailAdd("mithunkr0123@gmail.com");
		englishPage.enterpassword("testdata1234");
		englishPage.enterCnfPassword("testdata1234");
		englishPage.selectDateOfBirth("3", "9", "1995");
		Thread.sleep(3000);
		englishPage.clickOnSubmit();
		Thread.sleep(5000);
	}

	@Test
	public void validEnglishUkSignInTest() {
		englishPage.clickOnSignInLink();
		englishPage.loginToApp("mithunkr0123@gmail.com", "testdata1234");
		String title = englishPage.getTitle();
		Assert.assertEquals(title, "YOUR PROFILE");
	}

	@Test
	public void inValidEnglishUkSignInTest() {
		englishPage.clickOnSignInLink();
		englishPage.loginToApp("mithunkr0123@gmail.com", "testdat23");
		String actualError = englishPage.getErrorMessage();
		String expectedError = "The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
		Assert.assertEquals(actualError, expectedError);

	}

	@Test
	public void forgotPasswordTest() {
		englishPage.clickOnSignInLink();
		englishPage.verifyForgotPassword("mithunkr0123@gmail.com");
		String actualMsg = englishPage.getForgotMsg();
		String expectedMsg = "Didn't receive the e-mail? Return to the Reset Password page to try again.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@AfterMethod
	public void teardown(Method m) {
		driver.quit();
		logger.info("Chrome browser is closed");
		logger.info("\n"+"********** Test is completed: *********"+m.getName()+"***********"+"\n");
	}

}
