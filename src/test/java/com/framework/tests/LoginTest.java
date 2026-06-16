package com.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.core.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.JSONReader;
import com.framework.utils.Log;


public class LoginTest extends BaseTest {
	
	 @Test
	    public void verifyLogin() {

		    Log.logger.info(
		            "Reading Login Data");
		
		 JSONObject data =
	                JSONReader.getTestData("validUser");
	                         

	        String username = data.getString("username");
	        String password = data.getString("password");
	       
	        
	        LoginPage login = new LoginPage(driver);

	        login.login(username, password);
	        
	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("inventory"));
	       
	 }
	  
	 @Test
	        public void verifyinvalidLogin() {
	   		 
	   		 JSONObject data =
	   	                JSONReader.getTestData("lockedUser");
	   	                         

	   	        String username = data.getString("username");
	   	        String password = data.getString("password");

	   	        LoginPage login = new LoginPage(driver);

	   	        login.login(username, password);
	   	        
	   	     String actualError =
	   	    		driver.findElement(
	   	    		    By.xpath("//h3[@data-test='error']")
	   	    		).getText();

	   	    		Assert.assertEquals(
	   	    		    actualError,
	   	    		    "Epic sadface: Sorry, this user has been locked outqa."
	   	    		);
	    }
}
