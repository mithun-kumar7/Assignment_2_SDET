package com.qa.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase;



public class SpanishPage extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);
	
	public SpanishPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Registro')]")
	WebElement register_link;

	@FindBy(xpath = "//a[@class='event_profile_login']")
	WebElement signIn_link;
	
	@FindBy(id = "phdesktopbody_0_imgmale")
	WebElement male_img;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_grs_consumer[firstname]']")
	WebElement firstName_textBox;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_grs_consumer[lastname]']")
	WebElement lastName_textBox;
	
	@FindBy(xpath = "//input[@id='phdesktopbody_0_grs_account[emails][0][address]']")
	WebElement email_textBox;

	@FindBy(xpath = "//input[@id='phdesktopbody_0_grs_account[password][password]']")
	WebElement pwd_textBox;

	@FindBy(xpath = "//input[@id='phdesktopbody_0_grs_account[password][confirm]']")
	WebElement cnfPwd_textBox;
	
	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][day]")
	WebElement day_element;

	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][month]")
	WebElement month_element;

	@FindBy(id = "phdesktopbody_0_grs_consumer[birthdate][year]")
	WebElement year_element;
	
	@FindBy(id="phdesktopbody_0_grs_account[phones][0][fulltelephonenumber]")
	WebElement telephoneNumber;
	
	@FindBy(id = "phdesktopbody_0_submit")
	WebElement submit_btn;
	
	@FindBy(id = "phdesktopbody_0_username")
	WebElement logInEmail_txtBox;
	
	@FindBy(id = "phdesktopbody_0_password")
	WebElement logInPassword_txtBox;
	
	@FindBy(xpath = "//div[@class='pc_btn']//input[@type='submit']")
	WebElement signIn_btn;
	
	public static String converToNumber(String num) {
		int index = num.indexOf('.');
		return num.substring(0, index);
	}
	
	public void clickOnRegistrationLink() {
		register_link.click();
		logger.info("Clicked on registration link");
	}
	
	public void clickOnSignInLink() {
		signIn_link.click();
		logger.info("clicked on signin link");
	}
	
	public void loginToSite(String username, String password) {
		logInEmail_txtBox.sendKeys(username);
		logInPassword_txtBox.sendKeys(password);
		signIn_btn.click();
		logger.info("logged in into site: username="+username+" password="+password);
	}

	public void navigateToSpenishPage() {
		driver.navigate().to("https://www.olay.es/es-es");
		logger.info("navigated to spenish page");
	}
	
	public void fillRegistrationForm(String ftname, String ltName, String email, String pwd, String cnfPwd, int day,
			int month, int year, int phoneNumber) {
		male_img.click();
		firstName_textBox.sendKeys(ftname);
		lastName_textBox.sendKeys(ltName);
		email_textBox.sendKeys(email);
		pwd_textBox.sendKeys(pwd);
		cnfPwd_textBox.sendKeys(cnfPwd);
		String day_dob=String.valueOf(day);
		Select s1=new Select(day_element);
		s1.selectByVisibleText(day_dob);
		String month_dob=String.valueOf(month);
		Select s2=new Select(month_element);
		s2.selectByVisibleText(month_dob);
		String year_dob=String.valueOf(year);
		Select s3=new Select(year_element);
		s3.selectByVisibleText(year_dob);
		String numberTele=String.valueOf(phoneNumber);
		telephoneNumber.sendKeys(numberTele);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submit_btn);
		submit_btn.click();
		logger.info("Filled the registration page from excel");
	}
}
