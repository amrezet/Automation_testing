package com.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class SortDropdownTest extends BaseTest{
    private static final Logger logger = Logger.getLogger(SortDropdownTest.class.getName());

    @Test
    public void testPriceLowTOHighSort() {
        logger.log(Level.INFO, "Starting testPriceLowTOHighSort...");

        WebElement sortDropdown = driver.findElement(By.id(loc.getProperty("sort_dropdown")));
        // Select the 'Price Low-High' option.
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByVisibleText(loc.getProperty("price_low_to_high_filter"));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(loc.getProperty("product_price"))));
        
        logger.log(Level.INFO, "Products are displayed on the page.");

        List<WebElement> productPricesElements = driver.findElements(By.className(loc.getProperty("product_price")));
        // Create a list to store the product prices in ascending order.
        List<Float> sortedProductPrices = new ArrayList<Float>();

        // Iterate over the product prices and add them to the sorted list in ascending order.
        for (WebElement productPrice : productPricesElements) {
            String priceString = productPrice.getText();
            String priceWithoutDollarSign = priceString.substring(1);
            sortedProductPrices.add(Float.parseFloat(priceWithoutDollarSign));
        }

        logger.log(Level.INFO, "Prices extracted successfully.");

        // Assert that the product prices are in ascending order.
        boolean isSorted = isSortedAscending(sortedProductPrices);
        if (isSorted) {
            logger.log(Level.INFO, "Products are sorted in ascending order.");
        } else {
            logger.log(Level.WARNING, "Products are not sorted correctly.");
            Assert.fail("Products are not sorted correctly.");
        }

        logger.log(Level.INFO, "testPriceLowTOHighSort completed.");
    }

    private static boolean isSortedAscending(List<Float> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
