package ResuableMethods;

import TestFunctions.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//import static utils.extentreports.ExtentTestManager.getTest;

public class AllureTestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("AppiumDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");

        Object testClass = iTestResult.getInstance();
//         driver = BaseTest.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof AppiumDriver) {
            Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " onTestStart and screenshot taken!");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");

        Object testClass = iTestResult.getInstance();
//        AppiumDriver driver = BaseTest.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof AppiumDriver) {
            Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " passed and screenshot taken!");

        String testDescription = "";
        Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        Test testAnnotation = method.getAnnotation(Test.class);
        if (testAnnotation != null) {
            testDescription = testAnnotation.description(); // Capture the test description
        }

        String successMessage = testDescription.isEmpty()
                ? "Test passed"
                : "Test \"" + testDescription + "\" passed";

//        getTest().log(Status.PASS, successMessage);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
//        AppiumDriver driver = BaseTest.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof AppiumDriver) {
            Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
