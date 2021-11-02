package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

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
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyElements() {
		if(driver.findElement(oUserName).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oLogin).isDisplayed()&& driver.findElement(oRegister).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage enter_the_first_name(String firstname) {
		driver.findElement(oFirstName).sendKeys(firstname);
		return this;
	}

	public RegistrationPage enter_the_middle_name() {
		driver.findElement(oMiddleName).sendKeys("");
		return this;
	}

	public RegistrationPage enter_the_last_name(String sLastName) {
		driver.findElement(oLastName).sendKeys(sLastName);
		return this;
	}
	
	public RegistrationPage select_the_title() {
		Select oSelect = new Select(driver.findElement(oTitle));
		oSelect.selectByVisibleText("Mr");
		return this;
	}

	public RegistrationPage select_the_gender() {
		Select oSelect = new Select(driver.findElement(oGender));
		oSelect.selectByVisibleText("Male");
		return this;
	}

	public RegistrationPage enter_the_user_name(String username) {
		driver.findElement(oUserName).sendKeys(username);
		return this;
	}

	public RegistrationPage enter_the_email(String email) {
		driver.findElement(oEmail).sendKeys(email);
		return this;
	}

	public RegistrationPage enter_the_password(String password) {
		driver.findElement(oPassword).sendKeys(password);
		return this;
	}
	 
	public EmailVerificationPage click_on_register_button() {
		driver.findElement(oRegister).click();
		return new EmailVerificationPage(driver); 
	}
	
	public LoginPage clickOnLogin() {
		driver.findElement(oLogin).click();
		return new LoginPage(driver);
	}
	
}
