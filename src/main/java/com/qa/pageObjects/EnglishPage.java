package com.qa.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase;



public class EnglishPage extends TestBase {
	
	private static Logger logger=LogManager.getLogger(TestBase.class);

	public EnglishPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register_link;
	
	@FindBy(linkText = "Sign In")
	WebElement signIn_link;
	
	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_username")
	WebElement emadd_txtBox;
	
	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_password")
	WebElement pass_txtBox;
	
	@FindBy(xpath = "//input[@name='phdesktopbody_0$SIGN IN']")
	WebElement signIn_btn;

	@FindBy(id = "phdesktopbody_0_grs_account[emails][0][address]")
	WebElement email_txtbox;

	@FindBy(id = "phdesktopbody_0_grs_account[password][password]")
	WebElement password_txtbox;

	@FindBy(id = "phdesktopbody_0_grs_account[password][confirm]")
	WebElement cnfPass_txtbox;

	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][day]")
	WebElement day_dpdown;

	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]")
	WebElement month_dpdown;
	
	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][year]")
	WebElement year_dpdown;
	
	@FindBy(name = "phdesktopbody_0$phdesktopbody_0_submit")
	WebElement submit_btn;
	
	@FindBy(id = "phdesktopbody_0_TitleText")
	WebElement title;
	
	@FindBy(id = "phdesktopbody_0_Message")
	WebElement error_msg;
	
	@FindBy(id = "phdesktopbody_0_forgotpassword")
	WebElement forgotPass_link;
	
	@FindBy(id = "phdesktopbody_0_username")
	WebElement forgotPassEmail_txtBox;
	
	@FindBy(id = "phdesktopbody_0_NEXT")
	WebElement next_btn;
	
	@FindBy(xpath = "//div[@id='phdesktopbody_0_afterSubmit']//p")
	WebElement forgotPass_msg;
	
	public void clickOnRegisterLink() {
		register_link.click();
		logger.info("Clicked on Register link");
	}
	
	public void enterEmailAdd(String email) {
		email_txtbox.sendKeys(email);
		logger.info("Email add is entered");
	}
	
	public void enterpassword(String pwd) {
		password_txtbox.sendKeys(pwd);
		logger.info("Password is entered");
	}
	
	public void enterCnfPassword(String cnfPwd) {
		cnfPass_txtbox.sendKeys(cnfPwd);
		logger.info("Confirm password is entered");
	}
	
	public void selectDateOfBirth(String day,String month,String year) {
		Select day1 = new Select(day_dpdown);
		day1.selectByVisibleText(day);
		Select month1 = new Select(month_dpdown);
		month1.selectByVisibleText(month);
		Select year1 = new Select(year_dpdown);
		year1.selectByVisibleText(year);
		logger.info("Date of birth is selected as: "+day+"/"+month+"/"+year);
	}
	
	public void clickOnSubmit() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		submit_btn.click();
		logger.info("Clicked on submit button");
	}
	
	public void clickOnSignInLink() {
		signIn_link.click();
		logger.info("Clicked on signIn link");
	}
	
	public void loginToApp(String username, String password) {
		emadd_txtBox.sendKeys(username);
		pass_txtBox.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", signIn_btn);
		signIn_btn.click();
		logger.info("logged in to application");
	}
	
	public String getTitle() {
		logger.info("Tittle is captured");
		return title.getText();
		
	}
	
	public String getErrorMessage() {
		logger.info("Error message is captured");
		return error_msg.getText();
	}
	
	public void verifyForgotPassword(String email) {
		forgotPass_link.click();
		forgotPassEmail_txtBox.sendKeys(email);
		next_btn.click();
		logger.info("forgot password's email is entered and clicked on next");
	}
	
	public String getForgotMsg() {
		logger.info("forgot password errormessage is captured");
		return forgotPass_msg.getText();
	}
}
