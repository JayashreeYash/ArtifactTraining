package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//src/test/resources/features/Login_FB.feature",        // Path to feature files
    glue = "com.example.stepDefinitions",     // Path to step definition classes
//    plugin = {"pretty", "html:target/cucumber-reports"}, // Reporting options
    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true
)

public class TestRunner {
	
	
	
}
