package com.testcases;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class SignInCaptionAlignmentTest extends BaseTest {
    // Define a logger for the test class
    private static final Logger logger = Logger.getLogger(SignInCaptionAlignmentTest.class.getName());

    @Test
    public void captionTest() {
        logger.log(Level.INFO, "Starting captionTest...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        openProductCard();
        scrollToBottom(driver);
        fillSignInForm();
        
        // Handle pop up
        WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("popup_close_button"))));
        popupCloseButton.click();
        logger.log(Level.INFO, "Clicked the popup close button.");

        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("alignment_issue_signin_button"))));
        String verticalAlignValue = signInButton.getCssValue("vertical-align");
        logger.log(Level.INFO, "Vertical align value of the Sign In button: " + verticalAlignValue);

        Assert.assertEquals(verticalAlignValue, "middle", "Button is not vertically centered.");
        logger.log(Level.INFO, "captionTest completed.");
    }
    
    public void fillSignInForm() {
        WebElement username=driver.findElement(By.id(loc.getProperty("email_field")));
        username.sendKeys(prop.getProperty("email_address"));
        WebElement password=driver.findElement(By.id(loc.getProperty("password_field")));
        password.sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(loc.getProperty("signin_button_xpath"))).click();
        logger.log(Level.INFO, "Clicked the 'Sign In' button.");
    }
}
