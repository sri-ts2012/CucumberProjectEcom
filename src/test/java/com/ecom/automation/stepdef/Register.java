package com.ecom.automation.stepdef;

import java.util.Map;

import org.junit.Assert;

import com.ecom.automation.base.Base;
import com.ecom.automation.framework.Elements;
import com.ecom.automation.pages.HeadersSection;
import com.ecom.automation.pages.RegisterPage;
import com.ecom.automation.pages.SuccessPage;

import cucumber.api.DataTable;

import cucumber.api.java.en.*;

public class Register {
	
	HeadersSection headersSection =new HeadersSection();
	RegisterPage registerPage=new RegisterPage();
	SuccessPage successPage=new SuccessPage();
	
	@Given("^I launch the application$")
	public void i_launch_the_application()  {
	   Base.driver.get(Base.reader.getUrl());
	    
	}

	@And("^I navigate to account registration page$")
	public void i_navigate_to_account_registration_page()  {
	   Elements.click(HeadersSection.myAccountLink);
	   Elements.click(HeadersSection.register);
	   
	}

	@When("^I fill all the below valid details$")
	public void i_fill_all_the_below_valid_details(DataTable details)  {
		//instead of all the below code , put this as reusable method in the RegisterPage class
/*Map<String,String> map= details.asMap(String.class, String.class);
Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
//map.get(key) will retireve the value from the register.feature file
Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
Elements.TypeText(RegisterPage.email, map.get("Email"));
Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
Elements.TypeText(RegisterPage.password,map.get("Password"));
Elements.TypeText(RegisterPage.passwordConfirm, map.get("Password"));*/
		
		//RegisterPage.enterAllDetails(details);
		RegisterPage.enterAllDetails(details, "unique");
		
	   
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_Privacy_Policy()  {
	    Elements.click(RegisterPage.privacyPolicy);
	    
	}

	@And("^I click on Continue button$")
	public void i_click_on_Continue_button()  {
	   Elements.click(RegisterPage.continueButton);
	    
	}

	@Then("^I should see that the User Account has successfully created$")
	public void i_should_see_that_the_User_Account_has_successfully_created()  {
	  
		Assert.assertTrue(Elements.isDisplayed(SuccessPage.successBreadCrumb));
	
	 //return true wont matter what we want is assertion
	}


@Then("^I should see the user account is not created$")
public void i_should_see_the_user_account_is_not_created()  {
   //we can test this by assert of something displayed or not displayed
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerbreadcrumb));
 
}

@Then("^I should see the error message informing the user to enter the mandatory fields$")
public void i_should_see_the_error_message_informing_the_user_to_enter_the_mandatory_fields() {
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));
 Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));
 
}
@When("^I subscribe to Newsletter$")
public void i_subscribe_to_Newsletter() {
    Elements.click(RegisterPage.subscribeNewsletter);
    
}



@When("^I provide the below duplicate details$")
public void i_provide_the_below_duplicate_details(DataTable dupDetails)  {
 // RegisterPage.enterDuplicateDetails(dupDetails);
  //but in the registerpage is having the same method excet the email has timestamp for not duplciate
	RegisterPage.enterAllDetails(dupDetails,"duplicate");
}

@Then("^I should see that the user is restricted from creating duplicate account$")
public void i_should_see_that_the_user_is_restricted_from_creating_duplicate_account() {
	Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning,"Warning: E-Mail Address is already registered!"));
}

}
