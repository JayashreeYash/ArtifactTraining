package com.example.stepDefinitions;

import java.util.Scanner;

import ResuableMethods.PageUtility;
import TestFunctions.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CalculatorPageObjects;

public class CalculatorStepDefinitions extends CalculatorPageObjects {
	
	String firstNumber, secondNumber;
	
	@Given("Launch the calculator app")
	public void launch_the_calculator_app() {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
	    setup();
	}
	
	@When("get the numbers from console")
	public void get_the_numbers_from_console() {
		
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
		
		Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        this.firstNumber = scanner1.nextLine();	
        
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter the second number: ");
        this.secondNumber = scanner2.nextLine();
        
	}
	
	@Then("calculates sum of two number")
	public void calculates_sum_of_two_number() throws Exception {
		
		Add_two_number(firstNumber,secondNumber);
		
	}
	
	@Then("calculates multiple of two numbers")
	public void calculates_multiple_of_two_numbers() throws Exception {
		
		multiply_two_number(firstNumber, secondNumber);
		
	}
	@Then("calculates subtract of two numbers")
	public void calculates_subtract_of_two_numbers() throws Exception {
		
		subtract_two_number(firstNumber, secondNumber);
		
	}
	@Then("calculates division of two numbers")
	public void calculates_division_of_two_numbers() throws Exception {
		
		divide_two_number(firstNumber, secondNumber);
		
//		util.quit_Driver(driver);
		
	}

}
