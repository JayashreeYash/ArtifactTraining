package com.example.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import ResuableMethods.PageUtility;
import TestFunctions.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObjects;

public class loginStepDefinitions extends LoginPageObjects {
	
	@Given("User launches the app and user is on login page")
	public void user_launches_the_app_and_user_is_on_login_page() {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
	    setup();		
	}
	
	@Given("User navigates to enrollment screen")
	public void user_navigates_to_enrollment_screen() throws Exception {
		navigate_to_enrollmentScreen();		
	}

//	@When("User enters the valid credentials")
//	public void user_enters_the_valid_credentials() throws Exception {
//		Entering_the_valid_credentials();
//	}
	
	
	@When("User enters the valid credentials {string} and {string}")
	public void user_enters_the_valid_credentials_and(String string1, String string2) throws Exception {
		Enter_valid_credentials(string1, string2);
	}
	
	@When("clicks on verify button")
	public void clicks_on_verify_button() throws Exception {
		click_verify();
	}
	
//	@Then("User should be successfully logged in")
//	public void user_should_be_successfully_logged_in() {
//	    
//	}
	
	@Then("User should be successfully logged in {string}")
	public void user_should_be_successfully_logged_in(String string) {
		Assert.assertTrue(string, Successful_log_in(string));
	}
	
	
}
