package com.testcases;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class SignInButtonOverlapTest extends BaseTest {
    // Define a logger for the test class
    private static final Logger logger = Logger.getLogger(SignInButtonOverlapTest.class.getName());

    @Test
    public void overlapTest() {
        logger.log(Level.INFO, "Starting overlapTest...");

        openProductCard();
        scrollToBottom(driver);

        // Get the coordinates of the footer element
        WebElement footer = driver.findElement(By.xpath(loc.getProperty("footer_xpath")));
        int footerY = footer.getLocation().getY();

        // Get the coordinates of the sign In element
        WebElement signInButton = driver.findElement(By.xpath(loc.getProperty("signin_button_xpath")));
        int signInButtonY = signInButton.getLocation().getY();
        int signInButtonHeight = signInButton.getSize().height;

        // Calculate the bottom coordinate of the sign in button element
        int signInButtonBottomY = signInButtonY + signInButtonHeight;

        Assert.assertTrue(signInButtonBottomY <= footerY);
        logger.log(Level.INFO, "OverlapTest completed.");
    }
}
