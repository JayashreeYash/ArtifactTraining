package pageObjects;

import org.openqa.selenium.By;

import ResuableMethods.PageUtility;
import TestFunctions.BaseTest;
import io.cucumber.java.en.Then;

public class CalculatorPageObjects extends BaseTest {
	
	PageUtility util = new PageUtility();

	private By number_Buttons(char c) {
		By ele = By.xpath("//android.widget.TextView[@text='"+c+"']");
		return ele;
	}
	
	private By plus_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='plus']");
		return ele;
	}
	
	private By minus_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='minus']");
		return ele;
	}
	
	private By multiply_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='multiply']");
		return ele;
	}
	
	private By divide_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='divide']");
		return ele;
	}
	
	private By equals_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='equals']");
		return ele;
	}
	
	private By result_Displayed() {
		By ele = By.xpath("//android.widget.TextView[@resource-id='com.miui.calculator:id/result']");
		return ele;
	}
	
	private By clear_Button() {
		By ele = By.xpath("//android.widget.ImageView[@content-desc='clear']");
		return ele;
	}
	
	private void click_Numbers(String num) throws Exception {
		for(int i=0; i<num.length(); i++) {
			char c = num.charAt(i);
			util.Click(driver, number_Buttons(c), 5);
		}
	}
	
	public void Add_two_number(String firstNumber, String secondNumber) throws Exception {
		
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, clear_Button(), 5);
		util.Click(driver, clear_Button(), 2);
		Thread.sleep(1000);
		click_Numbers(firstNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, plus_Button(), 2);
		util.Click(driver, plus_Button(), 2);
		click_Numbers(secondNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, equals_Button(), 2);
		util.Click(driver, equals_Button(), 2);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, result_Displayed(), 3);
		String result = util.getText(driver, result_Displayed());
		System.out.println("Additions of two numbers "+firstNumber+" and "+secondNumber+" : "+result);
		
	}

	public void multiply_two_number(String firstNumber, String secondNumber) throws Exception {
		
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, clear_Button(), 5);
		util.Click(driver, clear_Button(), 2);
		click_Numbers(firstNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, minus_Button(), 2);
		util.Click(driver, minus_Button(), 2);
		click_Numbers(secondNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, equals_Button(), 2);
		util.Click(driver, equals_Button(), 2);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, result_Displayed(), 3);
		String result = util.getText(driver, result_Displayed());
		System.out.println("Subtraction of two numbers "+firstNumber+" and "+secondNumber+" : "+result);
		
	}

	public void subtract_two_number(String firstNumber, String secondNumber) throws Exception {
		
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, clear_Button(), 5);
		util.Click(driver, clear_Button(), 2);
		click_Numbers(firstNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, multiply_Button(), 2);
		util.Click(driver, multiply_Button(), 2);
		click_Numbers(secondNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, equals_Button(), 2);
		util.Click(driver, equals_Button(), 2);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, result_Displayed(), 3);
		String result = util.getText(driver, result_Displayed());
		System.out.println("Multiplication of two numbers "+firstNumber+" and "+secondNumber+" : "+result);
		
	}
	public void divide_two_number(String firstNumber, String secondNumber) throws Exception {
		
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, clear_Button(), 5);
		util.Click(driver, clear_Button(), 2);
		click_Numbers(firstNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, divide_Button(), 2);
		util.Click(driver, divide_Button(), 2);
		click_Numbers(secondNumber);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, equals_Button(), 2);
		util.Click(driver, equals_Button(), 2);
		util.wait_for_Element_isDisplayed(CurrentMethod, driver, result_Displayed(), 3);
		String result = util.getText(driver, result_Displayed());
		System.out.println("Division of two numbers "+firstNumber+" and "+secondNumber+" : "+result);
		
		util.quit_Driver(driver);
		
	}
	
}
