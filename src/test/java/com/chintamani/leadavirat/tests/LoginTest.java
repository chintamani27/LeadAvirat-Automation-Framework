
package com.chintamani.leadavirat.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.chintamani.leadavirat.base.BaseTest;
import com.chintamani.leadavirat.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPageElements() {

        driver.get("https://leadavirat.in/login");

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isEmailFieldDisplayed(),
                "Email field is not displayed");

        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(),
                "Password field is not displayed");

        Assert.assertTrue(loginPage.isSignInButtonDisplayed(),
                "Sign in button is not displayed");
    }
    

	@Test
	public void verifyLoginWithEmptyFields() {
	
	    driver.get("https://leadavirat.in/login");
	
	    LoginPage loginPage = new LoginPage(driver);
	
	    loginPage.clickSignIn();
	
	    String validationMessage = driver.findElement(
	        org.openqa.selenium.By.id("email")
	    ).getAttribute("validationMessage");
	
	    Assert.assertFalse(
	        validationMessage.isEmpty(),
	        "Expected browser validation message for empty email"
	    );
	}
	

	@Test
	public void verifyLoginWithInvalidEmailFormat() {
	
	    driver.get("https://leadavirat.in/login");
	
	    LoginPage loginPage = new LoginPage(driver);
	
	    loginPage.enterEmail("chintamani123");
	    loginPage.enterPassword("Test@123");
	
	    loginPage.clickSignIn();
	
	    String validationMessage = driver.findElement(
	        org.openqa.selenium.By.id("email")
	    ).getAttribute("validationMessage");
	
	    Assert.assertFalse(
	        validationMessage.isEmpty(),
	        "Expected validation message for invalid email format"
	    );
	}
	
	@Test
	public void verifyPasswordIsMasked() {

	    driver.get("https://leadavirat.in/login");

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.enterPassword("Test@123");

	    Assert.assertEquals(
	        loginPage.getPasswordFieldType(),
	        "password",
	        "Password field is not masked"
	    );
	}
	
	
	@Test
	public void verifySignUpNavigation() {
	
	    driver.get("https://leadavirat.in/login");
	
	    LoginPage loginPage = new LoginPage(driver);
	
	    loginPage.clickSignUp();
	
	    WebDriverWait wait = new WebDriverWait(
	        driver, Duration.ofSeconds(10)
	    );
	
	    boolean isNavigated = wait.until(
	        ExpectedConditions.urlContains("/register")
	    );
	
	    Assert.assertTrue(
	        isNavigated,
	        "User was not redirected to registration page"
	    );
	}





}
