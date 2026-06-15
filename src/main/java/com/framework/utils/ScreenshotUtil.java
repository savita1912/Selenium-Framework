package com.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.core.driver.DriverFactory;

public class ScreenshotUtil {
	public static String captureScreenshot(String testName) {

		String path = "reports/screenshots/" + testName + ".png";
        File src = ((TakesScreenshot)
                DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "screenshots/" + testName + ".png";    }

}
