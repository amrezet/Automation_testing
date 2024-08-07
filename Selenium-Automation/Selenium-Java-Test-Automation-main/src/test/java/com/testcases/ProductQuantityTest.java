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

public class ProductQuantityTest extends BaseTest {
    // Define a logger for the test class
    private static final Logger logger = Logger.getLogger(ProductQuantityTest.class.getName());

    @Test(priority = 1)
    public void testProductQuantityAsTwo() {
        logger.log(Level.INFO, "Starting testProductQuantity2...");
        addToCartAndGoToCart();
        // Increase product quantity to 2
        increaseProductQuantity();
        // Verify that the product quantity is 2
        assertProductQuantity(2);
        logger.log(Level.INFO, "testProductQuantity2 completed.");
    }

    @Test(priority = 2)
    public void testProductQuantityAsThree() {
        logger.log(Level.INFO, "Starting testProductQuantity3...");
        // Increase product quantity to 3
        increaseProductQuantity();
        // Verify that the product quantity is 3
        assertProductQuantity(3);
        logger.log(Level.INFO, "testProductQuantity3 completed.");
    }
    
    @Test(priority = 3)
    public void testProductQuantityAsFour() {
        logger.log(Level.INFO, "Starting testProductQuantity3...");
        // Increase product quantity to 4
        increaseProductQuantity();
        // Verify that the product quantity is 4
        assertProductQuantity(4);
        logger.log(Level.INFO, "testProductQuantity4 completed.");
    }

    private void increaseProductQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Click on increase button
        By increaseButtonLocator = By.xpath(loc.getProperty("amount_increase_button"));
        WebElement increaseButtonElement = wait.until(ExpectedConditions.elementToBeClickable(increaseButtonLocator));
        increaseButtonElement.click();
      
        driver.findElement(By.className(loc.getProperty("update_button"))).click();
        // Handle pop up
        WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("popup_close_button"))));
        popupCloseButton.click();

        WebElement secondPopupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("second_Popup_Close_Button"))));
        secondPopupCloseButton.click();
    }

    private void assertProductQuantity(int expectedQuantity) {
    	// Get the quantity after update
        WebElement inputElement = driver.findElement(By.className(loc.getProperty("quantity_input_field")));
        String inputValue = inputElement.getAttribute("value");
        int actualQuantity = Integer.parseInt(inputValue);
        
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }
}
