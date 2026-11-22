
package com.chintamani.leadavirat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By homeHeading = By.xpath(
        "//h1[contains(.,'Transform Your Business')]"
    );

    private By loginLink = By.linkText("Login");

    private By registerLink = By.linkText("Register");

    private By forgotPasswordLink = By.linkText("Forgot Password");

    private By contactLink = By.linkText("Contact");

    // Page Actions

    public boolean isHomePageDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(homeHeading)
        ).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void clickContact() {
        driver.findElement(contactLink).click();
    }
}
