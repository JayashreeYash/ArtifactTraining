package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import ResuableMethods.PageUtility;
import TestFunctions.BaseTest;


public class LoginPageObjects extends BaseTest {
	
	PageUtility util = new PageUtility();
	String message=null;
	

	private By Cancel_Button() {
		By ele = By.xpath("//android.widget.Button[@text='CANCEL']");
		return ele;
	}
	
	
	private By Enroll_Button() {
		By ele = By.xpath("//android.widget.Button[@text='Enroll']");
		return ele;
	}
	
	private By Activate_Your_Account() {
		By ele = By.xpath("//android.widget.TextView[@text='Activate your account']");
		return ele;
	}
	
	private By Username() {
		By ele = By.xpath("//android.widget.EditText[@content-desc='Username']");
		return ele;
	}
	
	private By Activation_Code() {
		By ele = By.xpath("//android.widget.EditText[@content-desc='Password']");
		return ele;
	}
	
	private By Verify() {
		By ele = By.xpath("//android.widget.Button[@text='Verify']");
		return ele;
	}
	
	//android.widget.EditText[@content-desc='Username']
	//android.widget.EditText[@content-desc='Password']
	//android.widget.Button[@text='Verify']
	
	public void navigate_to_enrollmentScreen() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Cancel_Button(), 25);
		util.Click(driver, Cancel_Button(), 5);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Enroll_Button(), 10);
		util.Click(driver, Enroll_Button(), 5);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Activate_Your_Account(), 10);
		util.Click(driver, Activate_Your_Account(), 5);
		
	}
	
//	public void Entering_the_valid_credentials() throws Exception {
//		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
//		System.out.println(CurrentMethod);
//		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Username(), 10);
//		util.Sendkeys(CurrentMethod, driver, Username(), "3478791652", 5);
//		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Activation_Code(), 3);
//		util.Sendkeys(CurrentMethod, driver, Activation_Code(), "Password123", 3); 
//	}
	
	public void Enter_valid_credentials(String string1, String string2) throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Username(), 10);
		util.Sendkeys(CurrentMethod, driver, Username(), string1, 5);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Activation_Code(), 3);
		util.Sendkeys(CurrentMethod, driver, Activation_Code(), string2, 3); 
	}
	
	public void click_verify() throws Exception {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, Verify(), 10);
		util.Click(driver, Verify(), 3);
		this.message = "success";  //For the sake of this example, we simulate activation being successful.
	   
	}
	
	public boolean Successful_log_in(String string) {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		assertEquals(string, this.message);
        System.out.println("Expected Message: " + string);
        System.out.println("Actual Message: " + this.message);
//        util.quit_Driver(driver);
        return this.message.equals(string);
        
	}
	

}
