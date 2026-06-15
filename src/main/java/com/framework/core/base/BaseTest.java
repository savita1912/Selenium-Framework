package com.framework.core.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.framework.core.config.ConfigReader;
import com.framework.core.driver.DriverFactory;


public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setup() {
    	 String browser = ConfigReader.get("browser");
    	 System.out.println("Browser from config: " + browser);
        driver = DriverFactory.initDriver(browser);
        System.out.println("Driver created successfully");
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
