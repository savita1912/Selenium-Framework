package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.Log;
import com.framework.wrappers.ActionUtils;

public class LoginPage {
	WebDriver driver;
    ActionUtils action;

//    @FindBy(id = "user-name")
//    WebElement username;
    
//    @FindBy(id = "password")
//    WebElement password;
    
//    @FindBy(id = "login-button")
//    WebElement loginBtn;
    By username =By.id("user-name");
    By password =By.id("password");
    By loginbutton =By.id("login-button");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        action = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
    	 Log.logger.info(
    	            "Performing Login");
        action.type(driver.findElement(username), user);
        action.type(driver.findElement(password), pass);
        action.click(driver.findElement(loginbutton));
    }

}
