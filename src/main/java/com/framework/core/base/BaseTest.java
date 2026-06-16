package com.framework.core.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.framework.core.config.ConfigReader;
import com.framework.core.driver.DriverFactory;
import com.framework.utils.Log;


public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setup() {
    	 String browser = ConfigReader.get("browser");
    	
    	 Log.logger.info(
                 "Launching Browser : " + browser);
    	 
        driver = DriverFactory.initDriver(browser);
        
        driver.get(ConfigReader.get("url"));
        Log.logger.info(
                "Navigated To : "
                        + ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
    	Log.logger.info(
                "Closing Browser");
        DriverFactory.quitDriver();
    }

}
