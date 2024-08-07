package com.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class SocialMediaLinkTest extends BaseTest {
    // Define a logger for the test class
    private static final Logger logger = Logger.getLogger(SocialMediaLinkTest.class.getName());

    @Test(priority = 1)
    public void testFacebookLink() {
        logger.log(Level.INFO, "Starting testFacebookLink...");
        String mainWindowHandle = driver.getWindowHandle();
        openProductCard();
        clickSocialMediaLink(loc.getProperty("facebook_button"));
        testSocialMediaLink(mainWindowHandle);
        logger.log(Level.INFO, "testFacebookLink completed.");
    }
    
    @Test(priority = 2)
    public void testLinkedInLink() {
        logger.log(Level.INFO, "Starting testLinkedInLink...");
        String mainWindowHandle = driver.getWindowHandle();
        clickSocialMediaLink(loc.getProperty("linkedin_button"));
        testSocialMediaLink(mainWindowHandle);
        logger.log(Level.INFO, "testLinkedInLink completed.");
    }
    
    @Test(priority = 3)
    public void testTwitterLink() {
        logger.log(Level.INFO, "Starting testTwitterLink...");
        String mainWindowHandle = driver.getWindowHandle();
        clickSocialMediaLink(loc.getProperty("twitter_button"));
        testSocialMediaLink(mainWindowHandle);
        logger.log(Level.INFO, "testTwitterLink completed.");
    }

    private void clickSocialMediaLink(String socialMediaXpath) {
        WebElement socialMediaLink = new WebDriverWait(driver, Duration.ofSeconds(50))
            .until(ExpectedConditions.elementToBeClickable(By.xpath(socialMediaXpath)));
        socialMediaLink.click();
        logger.log(Level.INFO, "Clicked on the social media link.");
    }

    private void testSocialMediaLink(String mainWindowHandle) {
        logger.log(Level.INFO, "Switching to a new tab...");

        String newTabHandle = null;

        // Identify and switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                newTabHandle = windowHandle;
                driver.switchTo().window(newTabHandle);
                break;
            }
        }

        if (newTabHandle != null) {
            String currentUrl = driver.getCurrentUrl();
            logger.log(Level.INFO, "Current URL: " + currentUrl);

            // Check if the URL contains a phrase indicating the error page
            if (!currentUrl.isEmpty()) {
                int statusCode = getHttpResponseCode(currentUrl);
                logger.log(Level.INFO, "HTTP Response Code: " + statusCode);

                // Check if the HTTP response code is not an error
                if (statusCode != 200) {
                    logger.log(Level.WARNING, "The link opened a page that indicates an error.");
                    Assert.fail("The link opened a page that indicates an error.");
                }
            }

            // Close the new tab
            driver.close();

            // Switch back to the main window
            driver.switchTo().window(mainWindowHandle);
            logger.log(Level.INFO, "Switched back to the main window.");
        }
    }

    private int getHttpResponseCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            logger.log(Level.WARNING, "UnknownHostException: The URL could not be resolved.");
            return -1;
        }
    }
}
