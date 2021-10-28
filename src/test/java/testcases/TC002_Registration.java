package testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	
  @Test(priority = 1)
  public void registrationFieldValidation() {
	  boolean result = new LoginPage()
			  			.clickRegisterLink().verifyElements();
	  Assert.assertTrue(result);
	  new RegistrationPage().clickOnLogin();
	 }
  
  @Test(priority = 2)
  public void regiterWithMandatoryFields() {
	  new LoginPage()
	      .clickRegisterLink()
	      .enter_the_first_name("Mathan")
	      .select_the_title()
	      .enter_the_middle_name()
	      .enter_the_last_name("Chandrasekaran")
	      .select_the_gender()
	      .enter_the_user_name("Credo"+randomNumGen())
	      .enter_the_email("Credo"+randomNumGen()+"@credosystemz.com")
	      .enter_the_password("credo123")
	      .click_on_register_button()
	      .verifyUserRegistration()
	      .clickOnLogin();
  }
  
  public int randomNumGen() {
	  Random ran = new Random();
	  return ran.nextInt(10000);
  }
  
  
  
}
