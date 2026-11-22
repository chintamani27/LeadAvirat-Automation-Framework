
package com.chintamani.leadavirat.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By fullNameField = By.id("fullName");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By passwordField = By.id("password");
    private By createAccountButton = By.xpath("//button[@type='submit']");
    private By signInLink = By.cssSelector("a[href='/login']");

    // Actions
    public void enterFullName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

 // Click Create Account button
    public void clickSignIn() {

        WebElement link = wait.until(
                ExpectedConditions.presenceOfElementLocated(signInLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the HTML document
        js.executeScript(
                "document.documentElement.scrollTop = " +
                "document.documentElement.scrollHeight;");

        wait.until(driver ->
                (Boolean) js.executeScript(
                        "return arguments[0].getBoundingClientRect().bottom <= window.innerHeight;",
                        link));

        wait.until(ExpectedConditions.elementToBeClickable(signInLink));

        link.click();
    }
    
    public void clickCreateAccount() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(createAccountButton));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "document.documentElement.scrollTop = " +
                "document.documentElement.scrollHeight;");

        wait.until(driver ->
                (Boolean) js.executeScript(
                        "return arguments[0].getBoundingClientRect().bottom <= window.innerHeight;",
                        button));

        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));

        button.click();
    }

    // Validation methods
    public boolean isFullNameFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField)).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).isDisplayed();
    }

    public boolean isPhoneFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isDisplayed();
    }

    public boolean isCreateAccountButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountButton)).isDisplayed();
    }

    public String getPasswordFieldType() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .getAttribute("type");
    }

    public String getPasswordMinLength() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .getAttribute("minlength");
    }
    


	




}
