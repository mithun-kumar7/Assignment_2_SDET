package com.qa.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase;
import com.qa.utils.JSONFileTestUtil;



public class ChineasePage extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);

	public ChineasePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='event_profile_login']")
	WebElement signIn_link;

	@FindBy(xpath = "//a[@class='event_profile_register']")
	WebElement register_link;

	@FindBy(id = "phdesktopbody_0_grs_consumer[lastname]")
	WebElement lastName_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_consumer[firstname]")
	WebElement firstName_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_account[emails][0][address]")
	WebElement registerEmail_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_account[phones][0][fulltelephonenumber]")
	WebElement phoneNumber_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_account[password][password]")
	WebElement password_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_account[password][confirm]")
	WebElement cnfPassword_txtBox;

	@FindBy(id = "phdesktopbody_0_grs_account[addresses][0][streetname]")
	WebElement streetName_txtBox;

	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]")
	WebElement month_element;

	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][year]")
	WebElement year_element;

	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_username")
	WebElement signInEmail_txtBox;

	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_password")
	WebElement signInPassword_txtBox;

	@FindBy(xpath = "//div[@class='pc_btn']//input[@type='submit']")
	WebElement signIn_btn;

	public void clickOnSignInLink() {
		signIn_link.click();
	}

	public void logInToSite(String username, String Password) {
		signInEmail_txtBox.sendKeys(username);
		signInPassword_txtBox.sendKeys(Password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", signIn_btn);
		signIn_btn.click();
		logger.info("Logged into application");
	}
	
	public void clickOnRegisterLink() {
		register_link.click();
		logger.info("Clicked on register link");
	}

	public void navigateToChineasePage() {
		driver.navigate().to("https://www.olay.com.hk/zh-hk/");
		logger.info("navigated to chinease page");
	}

	public void fillRegistrationForm() throws IOException, ParseException {
		
		lastName_txtBox.sendKeys(JSONFileTestUtil.getJSONData("Surname"));
		firstName_txtBox.sendKeys(JSONFileTestUtil.getJSONData("firstname"));
		registerEmail_txtBox.sendKeys(JSONFileTestUtil.getJSONData("EmailAddress"));
		phoneNumber_txtBox.sendKeys(JSONFileTestUtil.getJSONData("phoneNumber"));
		password_txtBox.sendKeys(JSONFileTestUtil.getJSONData("password"));
		cnfPassword_txtBox.sendKeys(JSONFileTestUtil.getJSONData("cnfPassword"));
		streetName_txtBox.sendKeys(JSONFileTestUtil.getJSONData("address"));
		Select s1=new Select(month_element);
		s1.selectByValue(JSONFileTestUtil.getJSONData("month"));
		Select s2=new Select(year_element);
		s2.selectByVisibleText(JSONFileTestUtil.getJSONData("year"));
		logger.info("Registration form in filled from JSON file");
	}
}
