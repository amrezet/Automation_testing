package com.testcases;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class ProductSearchTest extends BaseTest {
    // Define a logger for the test class
    private static final Logger logger = Logger.getLogger(ProductSearchTest.class.getName());

    @Test
    public void testSearchProduct() {
        logger.log(Level.INFO, "Starting testSearch...");

        String searchWord = prop.getProperty("keyword");
        openProductCard();
        WebElement inputField = driver.findElement(By.className(loc.getProperty("search_input_field")));
        inputField.sendKeys(searchWord);
        driver.findElement(By.xpath(loc.getProperty("search_button"))).click();

        searchWord = searchWord.toLowerCase();

        // Locate and gather all product elements on the search results page
        List<WebElement> products = driver.findElements(By.xpath(loc.getProperty("product_title")));

        // Loop through each product element and validate if it contains the keyword
        for (WebElement product : products) {
            String productText = product.getText().toLowerCase();

            if (productText.contains(searchWord)) {
                logger.log(Level.INFO, "Product contains the keyword '" + searchWord + "': " + product.getText());
            } else {
                logger.log(Level.INFO, "Product does not contain the keyword '" + searchWord + "': " + product.getText());
                Assert.fail("Product does not contain the keyword '" + searchWord + "'");
            }
        }

        logger.log(Level.INFO, "testSearch completed.");
    }
}

