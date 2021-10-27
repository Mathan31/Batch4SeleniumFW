package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	
  @Test(priority = 1)
  public void loginFieldValidation() {
	  boolean result = new LoginPage().verifyElements();
	  Assert.assertTrue(result);
  }
  
  @Test(priority = 2)
  public void loginWithValidCredential() {
	  new LoginPage()
	  .typeUserName("Mathan")
	  .typePassword("Testing123")
	  .clickSignIn()
	  .verifyHomePage()
	  .clickLogout();
  }
  
  @Test(priority = 3)
  public void loginWithInValidCredential() {
	  boolean result = new LoginPage()
	  .typePassword("Mathan123")
	  .typePassword("testing")
	  .clickSignIn_InvalidDetails()
	  .verifyElements();
	  Assert.assertTrue(result);
  }
}
