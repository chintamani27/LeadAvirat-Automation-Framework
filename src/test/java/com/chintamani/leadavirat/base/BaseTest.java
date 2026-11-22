
package com.chintamani.leadavirat.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.chintamani.leadavirat.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
