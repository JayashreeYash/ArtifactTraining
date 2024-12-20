package com.example.stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;

import ResuableMethods.PageUtility;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hooks { 
    private static AppiumDriver driver;
    PageUtility util = new PageUtility();
 
    String Application = util.readProperty("Application");
 
 
    @Before
    public void setup() {
        if(driver == null ){
            try{
            DesiredCapabilities caps = new DesiredCapabilities();
            if(Application.equalsIgnoreCase("MB_Android_App")) {
                caps.setCapability("appium:deviceName", util.readProperty("Device_Name"));
                caps.setCapability("appium:platformName", util.readProperty("Platform"));
                caps.setCapability("appium:platformVersion", util.readProperty("Platform_Version"));
                caps.setCapability("appium:app", util.readProperty("App"));
                caps.setCapability("appium:automationName", util.readProperty("Automation_Name"));
                caps.setCapability("noReset", true);
                caps.setCapability("autoGrantPermissions", true);
//			caps.setCapability("appium:appPackage", util.readProperty("AppPackage"));
            }else if(Application.equalsIgnoreCase("MB_IOS_App")) {
 
            }else if(Application.equalsIgnoreCase("Mobile_Browser")) {
                caps.setCapability("appium:deviceName", util.readProperty("Mobile_Web_Device_Name"));
                caps.setCapability("appium:platformName", util.readProperty("Mobile_Web_Platform"));
                caps.setCapability("appium:platformVersion", util.readProperty("Mobile_Web_Platform_Version"));
                caps.setCapability("appium:browserName", util.readProperty("Mobile_Web_browserName"));
                caps.setCapability("appium:chromedriverExecutable", util.readProperty("Mobile_Web_Executable"));
                caps.setCapability("appium:automationName", util.readProperty("Mobile_Web_Automation_Name"));
                caps.setCapability("noReset", true);
                caps.setCapability("autoGrantPermissions", true);
            }
 
 
                if(Application.equalsIgnoreCase("Mobile_Browser")) {
                	System.out.println("********** Starting driver setup ******* " );
                    driver = new AppiumDriver<>(new URL(util.readProperty("Appium_Url")), caps);
                    System.out.println("Driver Initialized Successfully : " + Application);
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    
                }else {
                    driver = new AppiumDriver<>(new URL(util.readProperty("Appium_Url")), caps);
                    System.out.println("Driver Initialized Successfully : " + Application);
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
 
 
            }catch (Exception e) {
                System.out.println("Failed to Initialized Driver. Please check Appium url");
                e.printStackTrace();
            }
 
        }
 
 
    }
 
    @After
    public void tearDown() throws IOException {
        System.out.println("Tearing down Appium driver...");
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure driver is reset between tests
            System.out.println("Appium driver quit successfully.");
        }
 
        String command = "cmd /c start cmd.exe /K \" COLOR 30 && cd \"C:\\Users\\jayashreev\\OneDrive - Maveric Systems Limited\\Desktop\\Mobile Automation Training\\TrainingWorkspace\\ArtifactTraining && allure serve allure-results";
        //        String command = "cmd /c start cmd.exe /K \" COLOR 30 && cd \"C:\\Users\\vivekak\\Downloads\\Combined_ANBTestNG_FrameWork\\target && allure serve allure-results";
        Process chiledprocess = Runtime.getRuntime().exec(command);
 
 
        String command1 = "cmd /c start cmd.exe /K \" COLOR 30 && cd \"C:\\Users\\jayashreev\\OneDrive - Maveric Systems Limited\\Desktop\\Mobile Automation Training\\TrainingWorkspace\\ArtifactTraining && rmdir /s /q allure-report && allure generate --single-file allure-results";
        //        String command1 = "cmd /c start cmd.exe /K \" COLOR 30 && cd \"C:\\Users\\vivekak\\Downloads\\Combined_ANBTestNG_FrameWork\\target && rmdir /s /q allure-report && allure generate --single-file allure-results";
        Process chiledprocess1 = Runtime.getRuntime().exec(command1);
 
    }
 
	public static AppiumDriver getDriver() {
		System.out.println("Returning Appium driver instance...");
		return driver;
	}}

