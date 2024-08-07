package com.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr_configs;
	public static FileReader fr_locators;
	
	public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
	public static void openProductCard() {
        WebElement productCard = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc.getProperty("product_card"))));
        productCard.click();
    }
	public static void addToCartAndGoToCart() {
        driver.findElement(By.xpath(loc.getProperty("homepage_addtocart_button"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(loc.getProperty("view_cart"))));
        driver.findElement(By.linkText(loc.getProperty("view_cart"))).click();
    }
	
	@BeforeClass
	public void setUp() throws IOException {
		if(driver==null) {
			FileReader fr_configs=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr_locators=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

			prop.load(fr_configs);
			loc.load(fr_locators);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
	        driver = new ChromeDriver(); 
	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
	        driver = new FirefoxDriver(); 
	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("testurl"));
		}
	}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
            driver.quit(); // Close the browser properly
        }
	}
}
