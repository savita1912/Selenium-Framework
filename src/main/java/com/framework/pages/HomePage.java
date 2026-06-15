package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.wrappers.ActionUtils;

public class HomePage {
	
	
	WebDriver driver;
    ActionUtils action;

    By addToCartBtn=By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon=By.id("shopping_cart_link");
    
   

    public HomePage(WebDriver driver) {
        this.driver = driver;
        action = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        action.click(driver.findElement(addToCartBtn));
    }

    public void openCart() {
        action.click(driver.findElement(cartIcon));
    }
	

}
