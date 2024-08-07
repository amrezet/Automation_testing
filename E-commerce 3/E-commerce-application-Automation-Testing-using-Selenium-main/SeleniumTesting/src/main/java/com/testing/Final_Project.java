package com.final_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Final_Project {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.get("http://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

//        User Id
        driver.findElement(By.xpath("//input[@id='input-email']"))
                .sendKeys("abcd4321@mailmail.com");

//        User Password
        driver.findElement(By.xpath("//input[@id='input-password']"))
                .sendKeys("Test@3210");

//        Login Button
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

//        Clicked Laptop and notebook bar
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[3]")).click();

//        Show all laptop and notebooks
        driver.findElement(By.xpath("(//a[@class='see-all'])[2]")).click();

        driver.findElement(By.xpath("//span[starts-with(@class,'hidden-xs') and text()='Add to Cart']"));

        driver.findElement(By.xpath("//a[text()='MacBook Pro']")).click();
        driver.findElement(By.xpath("//button[@id='button-cart' and @type='button']")).click();

//        driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();
//        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
//        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();

//        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        String pro1 = driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String pro2 = driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();
        if (pro1.equals("MacBook Air")){
            System.out.println("Product 1 is ok");
        }else {
            System.out.println("Product 1 is not ok");
        }
        if (pro2.equals("MacBook Pro")){
            System.out.println("Product 2 is ok");
        }else {
            System.out.println("Product 2 is not OK");
        }

        String totalAmt = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[2]/td[2]")).getText();
        if (totalAmt.equals("$3,000.00")){
            System.out.println("Price OK");
        }else {
            System.out.println("Price Not Ok");
        }

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        driver.close();

    }
}
