package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oLogin = By.xpath("//a[text()='Login']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public RegistrationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyElements() {
			
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUserName)) && oWrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& oWrap.verifyDisplayedwithReturn(driver.findElement(oLogin))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oRegister))) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage enter_the_first_name(String firstname) {
		oWrap.type(driver.findElement(oFirstName), firstname);
		return this;
	}

	public RegistrationPage enter_the_middle_name() {
		oWrap.type(driver.findElement(oMiddleName), "");
		return this;
	}

	public RegistrationPage enter_the_last_name(String sLastName) {
		oWrap.type(driver.findElement(oLastName), sLastName);
		return this;
	}
	
	public RegistrationPage select_the_title() {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oTitle), "Mr");
		return this;
	}

	public RegistrationPage select_the_gender() {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oGender), "Male");
		return this;
	}

	public RegistrationPage enter_the_user_name(String username) {
		oWrap.type(driver.findElement(oUserName), username);
		return this;
	}

	public RegistrationPage enter_the_email(String email) {
		oWrap.type(driver.findElement(oEmail), email);
		return this;
	}

	public RegistrationPage enter_the_password(String password) {
		oWrap.type(driver.findElement(oPassword), password);
		return this;
	}
	 
	public EmailVerificationPage click_on_register_button() {
		oWrap.click(driver.findElement(oRegister));
		return new EmailVerificationPage(driver,node); 
	}
	
	public LoginPage clickOnLogin() {
		oWrap.click(driver.findElement(oLogin));
		return new LoginPage(driver,node);
	}
	
}
