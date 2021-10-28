package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	
	public boolean verifyElements() {
		if(driver.findElement(oUsername).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oSignIn).isDisplayed()&& driver.findElement(oRegister).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage typeUserName(String sUserName) {
		driver.findElement(oUsername).sendKeys(sUserName);
		return this;
	}
	
	public LoginPage typePassword(String sPassword) {
		driver.findElement(oPassword).sendKeys(sPassword);
		return this;
	}
	
	public HomePage clickSignIn() {
		driver.findElement(oSignIn).click();
		return new HomePage();
	}
	
	public LoginPage clickSignIn_InvalidDetails() {
		driver.findElement(oSignIn).click();
		return this;
	}
	
	public RegistrationPage clickRegisterLink() {
		driver.findElement(oRegister).click();
		return new RegistrationPage();
	}
	

}
