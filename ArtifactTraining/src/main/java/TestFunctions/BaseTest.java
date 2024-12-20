package TestFunctions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import ResuableMethods.PageUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	public static AppiumDriver driver;
	PageUtility util = new PageUtility();
	
	String Application = util.readProperty("Application");
	
	public void setup() {
		
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
		
		try {
			if(Application.equalsIgnoreCase("Mobile_Browser")) {
				driver = new AppiumDriver<>(new URL(util.readProperty("Appium_Url")), caps);
				driver.get(util.readProperty("Mobile_Web_Url"));
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
