package com.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.reporting.ExtentManager;
import com.framework.utils.Log;
import com.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        
        Log.logger.info(
                "====================================");

        Log.logger.info(
                "TEST STARTED : "
                        + result.getMethod()
                                .getMethodName());
        Log.logger.info(
                "====================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
        Log.logger.info(
                "TEST PASSED : "
                        + result.getMethod()
                                .getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());
        

        Log.logger.error(
                "TEST FAILED : "
                        + result.getMethod()
                                .getMethodName());

        Log.logger.error(
                result.getThrowable());
        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        result.getMethod().getMethodName());

        try {

            test.get().addScreenCaptureFromPath(
                    screenshotPath);
            Log.logger.info(
                    "Screenshot Attached : "
                            + screenshotPath);

        } catch (Exception e) {
        	Log.logger.error(
                    "Unable To Attach Screenshot");
            e.printStackTrace();
        }

        System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	Log.logger.info(
                "====================================");

        Log.logger.info(
                "TEST EXECUTION COMPLETED");
        extent.flush();
    }
}