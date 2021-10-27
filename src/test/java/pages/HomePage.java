package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class HomePage extends BaseClass{
	private By oWelcome = By.xpath("//h3[contains(text(),' Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	
	public HomePage verifyHomePage() {
		boolean result = driver.findElement(oWelcome).isDisplayed();
		if(result) {
			System.out.println("User Login is Successfull!!!");
		}else {
			System.out.println("User Login Failed!!!");
		}
		return this; 
	}
	
	public LoginPage clickLogout() {
		//driver.findElement(oLogout).click();
		driver.findElement(oLogout).click();
		return new LoginPage();
	}

}
