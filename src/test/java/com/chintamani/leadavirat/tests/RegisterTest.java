
package com.chintamani.leadavirat.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.chintamani.leadavirat.base.BaseTest;
import com.chintamani.leadavirat.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyRegisterPageElements() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        Assert.assertTrue(registerPage.isFullNameFieldDisplayed(),
                "Full name field is not displayed");

        Assert.assertTrue(registerPage.isEmailFieldDisplayed(),
                "Email field is not displayed");

        Assert.assertTrue(registerPage.isPhoneFieldDisplayed(),
                "Phone field is not displayed");

        Assert.assertTrue(registerPage.isPasswordFieldDisplayed(),
                "Password field is not displayed");

        Assert.assertTrue(registerPage.isCreateAccountButtonDisplayed(),
                "Create account button is not displayed");
    }

    @Test
    public void verifyPasswordIsMasked() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        Assert.assertEquals(registerPage.getPasswordFieldType(), "password",
                "Password is not masked");
    }

    @Test
    public void verifyPasswordMinimumLength() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        Assert.assertEquals(registerPage.getPasswordMinLength(), "8",
                "Password minimum length is not 8");
    }

    @Test
    public void verifySignInNavigation() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.clickSignIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean navigated = wait.until(
                ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(navigated,
                "User was not redirected to login page");
    }
    
    @Test
    public void verifyEmptyRegistrationFormValidation() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.clickCreateAccount();

        String validationMessage = driver.findElement(
                org.openqa.selenium.By.id("fullName"))
                .getAttribute("validationMessage");

        Assert.assertFalse(validationMessage.isEmpty(),
                "Required validation did not appear for full name");
    }
    
    @Test
    public void verifyInvalidEmailFormat() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterFullName("Test User");
        registerPage.enterEmail("invalidemail");
        registerPage.enterPassword("Test@123");

        registerPage.clickCreateAccount();

        String validationMessage = driver.findElement(By.id("email"))
                .getAttribute("validationMessage");

        Assert.assertFalse(validationMessage.isEmpty(),
                "Invalid email validation message was not displayed");
    }
    
    @Test
    public void verifyEmailRequiredValidation() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterFullName("Test User");
        registerPage.clickCreateAccount();

        String validationMessage = driver.findElement(By.id("email"))
                .getAttribute("validationMessage");

        Assert.assertFalse(validationMessage.isEmpty(),
                "Email required validation message was not displayed");
    }
    
    @Test
    public void verifyPhoneNumberIsOptional() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterFullName("Test User");
        registerPage.enterEmail("test@example.com");
        registerPage.enterPassword("Test@123");

        String required = driver.findElement(By.id("phone"))
                .getAttribute("required");

        Assert.assertNull(required,
                "Phone number field should be optional");
    }
    
    @Test
    public void verifyPhoneNumberAcceptsInput() {

        driver.get("https://leadavirat.in/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterPhone("9876543210");

        String enteredPhone = driver.findElement(By.id("phone"))
                .getAttribute("value");

        System.out.println("Actual phone value: " + enteredPhone);
        System.out.println("Phone input value: " +
                driver.findElement(By.id("phone")).getAttribute("value"));
    }
}
