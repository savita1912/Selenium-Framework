package com.framework.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.utils.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //separate WebDriver for each thread

   public static WebDriver initDriver(String browser) {
//        WebDriverManager.chromedriver().setup();
//        driver.set(new ChromeDriver());
//        return getDriver();
//    }
	   
	   
// this is for using different browsser
	   
	   Log.logger.info("Creating Driver For : "
	                    + browser);
	   
    if(browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        
        Log.logger.info(
                "Chrome Browser Started");
    }

    else if(browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
        Log.logger.info(
                "Firefox Browser Started");
       
    }
    else if(browser.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        driver.set(new EdgeDriver());
        Log.logger.info(
                "Edge Browser Started");
    }
    else {
        throw new RuntimeException("Browser not supported: " + browser);
    }
    return getDriver();
   }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}
