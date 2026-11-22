
package com.chintamani.leadavirat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By emailField = By.id("email");

    private By passwordField = By.id("password");

    private By signInButton = By.xpath("//button[@type='submit']");

    private By signUpLink =
            By.cssSelector("a[href='/register']");

    private By partnerLoginLink = By.linkText("Partner login");

    // Page Actions

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }

    public void clickSignUp() {
        driver.findElement(signUpLink).click();
    }
    

    public void clickPartnerLogin() {
        driver.findElement(partnerLoginLink).click();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isSignInButtonDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }
    
    public String getPasswordFieldType() {
        return driver.findElement(passwordField)
                     .getAttribute("type");
    }
}
