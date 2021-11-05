package testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	

	@BeforeTest
	public void setUpTestCase() {
		sSheetName = "TC002";
		authors = "Monisha";
		category = "Sanity";
		testCaseName = "Registration";
		testDescription = "Testing the Registration functionality";
		module = "Registration Module";
	}
	
  @Test(priority = 1)
  public void registrationFieldValidation() {
	  boolean result = new LoginPage(driver,node)
			  			.clickRegisterLink().verifyElements();
	  Assert.assertTrue(result);
	  new RegistrationPage(driver,node).clickOnLogin();
	 }
  
  @Test(priority = 2,dataProvider = "ExcelData")
  public void regiterWithMandatoryFields(String fName,String lName,String uName,String email,String password) {
	  new LoginPage(driver,node)
	      .clickRegisterLink()
	      .enter_the_first_name(fName)
	      .select_the_title()
	      .enter_the_middle_name()
	      .enter_the_last_name(lName)
	      .select_the_gender()
	      .enter_the_user_name(uName+randomNumGen())
	      .enter_the_email(email+randomNumGen()+"@credosystemz.com")
	      .enter_the_password(password)
	      .click_on_register_button()
	      .verifyUserRegistration()
	      .clickOnLogin();
  }
  
  public int randomNumGen() {
	  Random ran = new Random();
	  return ran.nextInt(10000);
  }
  
  
  
}
