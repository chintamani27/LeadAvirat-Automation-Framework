
package com.chintamani.leadavirat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chintamani.leadavirat.base.BaseTest;
import com.chintamani.leadavirat.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
            homePage.isHomePageDisplayed(),
            "Home page heading is not displayed"
        );
    }
}
