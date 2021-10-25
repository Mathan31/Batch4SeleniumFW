package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	
	public void typeUserName(String sUserName) {
		driver.findElement(oUsername).sendKeys(sUserName);
	}
	
	public void typePassword(String sPassword) {
		driver.findElement(oPassword).sendKeys(sPassword);
	}
	
	public void clickSignIn() {
		driver.findElement(oSignIn).click();
	}
	
	public void clickSignIn_InvalidDetails() {
		
	}
	

}
