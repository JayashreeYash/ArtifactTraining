package pageObjects;

import org.openqa.selenium.By;

import ResuableMethods.PageUtility;
import TestFunctions.BaseTest;
import io.appium.java_client.AppiumDriver;

public class UdemyLoginPageObjects extends BasePage{
	
	public UdemyLoginPageObjects(AppiumDriver driver) {
        super(driver);
    }
	
	//android.widget.Button[@resource-id="nav-hamburger-menu"]
	//android.widget.EditText[@resource-id="nav-search-keywords"]
	//android.view.View[@resource-id="nav-search-form"]/android.view.View[2]/android.view.View/android.widget.TextView
	//android.widget.TextView[@resource-id="hmenu-header-account-text"]
	PageUtility util = new PageUtility();
	String message=null;
	
	//android.widget.Button[@resource-id="nav-hamburger-menu"]
	
	private By hamburger_Menu() {
		By ele = By.xpath("//button[@id='nav-hamburger-menu']");
		return ele;
	}

	private By search_bar() {
		By ele = By.xpath("//android.widget.EditText[@resource-id='nav-search-keywords']");
		return ele;
	}
	
	private By search_icon() {
		By ele = By.xpath("//android.view.View[@resource-id='nav-search-form']/android.view.View[2]/android.view.View/android.widget.TextView");
		return ele;
	}
	
	private By account_SignIn() {
		By ele = By.xpath("//android.widget.TextView[@resource-id='hmenu-header-account-text']");
		return ele;
	}
	
	private By email_ID() {
		By ele = By.xpath("//android.widget.EditText[@resource-id='ap_email_login']");
		return ele;
	}
	
	private By continue_Button() {
		By ele = By.xpath("//android.widget.Button[@resource-id='continue']");
		return ele;
	}
	
	private By password_Button() {
		By ele = By.xpath("//android.widget.EditText[@resource-id='ap_password']");
		return ele;
	}
	
	private By sign_Button() {
		By ele = By.xpath("//android.widget.Button[@resource-id='signInSubmit']");
		return ele;
	}
	
	private By invalid_login_Error_Message() {
		By ele = By.xpath("//android.view.View[@text='Your password is incorrect']");
		return ele;
	}
	
	public void click_hamburgerMenu() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, hamburger_Menu(), 25);
		util.Click(driver, hamburger_Menu(), 5);
		
	}
	
	public void click_accountsignin() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, account_SignIn(), 25);
		util.Click(driver, account_SignIn(), 5);
	}
	
	public void enter_emailID(String emailID) throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, email_ID(), 10);
		util.Sendkeys(CurrentMethod, driver, email_ID(), emailID, 5);
	}
	
	public void click_continueButton() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, continue_Button(), 25);
		util.Click(driver, continue_Button(), 5);
	}
	
	public void enter_password(String password) throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, password_Button(), 10);
		util.Sendkeys(CurrentMethod, driver, password_Button(), password, 5);
	}
	
	public void click_signinButton() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, sign_Button(), 25);
		util.Click(driver, sign_Button(), 5);
	}
	
	public boolean isLoginErrorVisible() throws Exception {
        return util.isDisplayed(driver, invalid_login_Error_Message());
    }
	
}
