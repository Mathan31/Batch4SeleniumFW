package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void setUpTestCase() {
		sSheetName = "TC001";
		authors = "Mathi";
		category = "Smoke";
		testCaseName = "Login";
		testDescription = "Testing the Login functionality";
		module = "Login Module";
	}
	
	
  @Test(priority = 1)
  public void loginFieldValidation() {
	  boolean result = new LoginPage(driver,node).verifyElements();
	  Assert.assertTrue(result);
  }
  
  @Test(priority = 2,dataProvider = "ExcelData")
  public void loginWithValidCredential(String sUName,String sPW) {
	  new LoginPage(driver,node)
	  .typeUserName(sUName)
	  .typePassword(sPW)
	  .clickSignIn()
	  .verifyHomePage()
	  .clickLogout();
  }
  
  @Test(priority = 3)
  public void loginWithInValidCredential() {
	  boolean result = new LoginPage(driver,node)
	  .typeUserName("Mathan123")
	  .typePassword("testing")
	  .clickSignIn_InvalidDetails()
	  .verifyElements();
	  Assert.assertTrue(result);
  }
}
