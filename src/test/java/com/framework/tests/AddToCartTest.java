package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.core.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

public class AddToCartTest extends BaseTest {

	@Test
    public void verifyAddToCart() {

        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add product
        HomePage home = new HomePage(driver);
        home.addProductToCart();

        // Open cart
        home.openCart();

        // Validate product
        //CartPage cart = new CartPage(driver);

//        Assert.assertEquals(
//            cart.getProductName(),
//            "Sauce Labs Backpack"
//        );
    }
}
