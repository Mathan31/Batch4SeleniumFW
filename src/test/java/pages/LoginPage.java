package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyElements() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUsername)) && oWrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& oWrap.verifyDisplayedwithReturn(driver.findElement(oSignIn))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oRegister))) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage typeUserName(String sUserName) {
		oWrap.type(driver.findElement(oUsername), sUserName);
		return this;
	}
	
	public LoginPage typePassword(String sPassword) {
		oWrap.type(driver.findElement(oPassword), sPassword);
		return this;
	}
	
	public HomePage clickSignIn() {
		oWrap.click(driver.findElement(oSignIn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickSignIn_InvalidDetails() {
		oWrap.click(driver.findElement(oSignIn));
		return this;
	}
	
	public RegistrationPage clickRegisterLink() {
		oWrap.click(driver.findElement(oRegister));
		return new RegistrationPage(driver,node);
	}
	

}
