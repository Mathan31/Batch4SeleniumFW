package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class EmailVerificationPage extends BaseClass{
	
	private By oWelcome = By.xpath("//*[text()=' Welcome To The UiBank Family! ']");
	private By oLogin = By.linkText("Login");
	private WebDriver driver;
	
	public EmailVerificationPage(WebDriver driver) {
		this.driver = driver;
				
	}
	
	
	public EmailVerificationPage verifyUserRegistration() {
		boolean displayed = driver.findElement(oWelcome).isDisplayed();
		if(displayed) {
			System.out.println("User Registration is Successfull!!!");
		}else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	}
	
	public LoginPage clickOnLogin() {
		driver.findElement(oLogin).click();
		return new LoginPage(driver);
	}
	}

