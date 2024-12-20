package com.example.stepDefinitions;

import java.util.Set;

import org.junit.Assert;

import ResuableMethods.PageUtility;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UdemyLoginPageObjects;


public class UdemyLoginStepDefinitions {
	
	PageUtility util = new PageUtility();
	
	private AppiumDriver driver;
	private UdemyLoginPageObjects lpg;

	public UdemyLoginStepDefinitions() {

		System.out.println("Initializing LoginSteps...");

		this.driver = Hooks.getDriver();

		if (driver == null) {

			System.out.println("Driver is null in LoginSteps constructor!");

			throw new RuntimeException("Driver is not initialized.");

		}
		this.lpg = new UdemyLoginPageObjects(driver);

	}

	@Given("User lanches the udemy mobile homepage")

	public void user_lanches_the_udemy_mobile_homepage() {

		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();

		System.out.println(CurrentMethod);

			// setup();
	
	    driver.get(util.readProperty("Mobile_Web_Url"));
	    
	    Set<String> contexts = driver.getContextHandles();
        System.out.println("Available contexts: " + contexts);

        // Switch to web view
        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context); // Switch to WebView
                break;
            }else if (context.contains("CHROMIUM")) {
                driver.context(context);  // Switch to the web view
                break;
            }
        }

	}

	@Given("User navigated to loginpage")

	public void user_navigated_to_loginpage() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		lpg.click_hamburgerMenu();
		lpg.click_accountsignin();
		

	}

	@When("user enters the email id {string} and password {string}")

	public void user_enters_the_email_id_and_password(String string, String string2) throws Exception {
		lpg.enter_emailID(string);
		lpg.click_continueButton();
		lpg.enter_password(string2);
		lpg.click_signinButton();
		

	}

	@Then("User views the invalid login errors")

	public void user_views_the_invalid_login_errors() throws Exception {
		Assert.assertTrue("Login error message should be visible", lpg.isLoginErrorVisible());
	}
}
