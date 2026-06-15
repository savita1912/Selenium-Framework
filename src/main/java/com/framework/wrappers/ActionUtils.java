package com.framework.wrappers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {

	 WebDriver driver;
	    WebDriverWait wait;

	    public ActionUtils(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void click(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	    }

	    public void type(WebElement element, String text) {
	        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	    }

	    public String getText(WebElement element) {
	        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	    }
}
